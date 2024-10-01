import {Component, OnInit} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from "@angular/forms";
import {Candidate, Voter} from "../../models/models";
import {CastVoteService} from "../../services/cast-vote/cast-vote.service";

@Component({
  selector: 'app-cast-vote',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './cast-vote.component.html',
  styleUrls: ['./cast-vote.component.scss']
})
export class CastVoteComponent implements OnInit {

  voters: Voter[] = [];
  candidates: Candidate[] = [];
  selectedVoter: number | null = null;
  selectedCandidate: number | null = null;
  alertMessage: string | null = null;
  alertType: string | null = null;

  constructor(private voteService: CastVoteService) {
  }

  ngOnInit(): void {
    this.fetchVoters();
    this.fetchCandidates();
  }

  fetchVoters(): void {
    this.voteService.fetchVoters().subscribe(data => {
      this.voters = data.map(voter => ({
        ...voter,
        hasVoted: voter.candidateId !== null,
      }));
    });
  }

  fetchCandidates(): void {
    this.voteService.fetchCandidates().subscribe(data => {
      this.candidates = data;
    });
  }

  submitVote() {
    this.voteService.submitVote(this.selectedVoter, this.selectedCandidate)
      .subscribe({
        next: (responseMessage) => {
          this.alertMessage = responseMessage;
          this.alertType = 'success';
        },
        error: (error) => {
          this.alertMessage = 'Error: ' + error.message;
          this.alertType = 'error';
        }
      });
  }

  closeAlert() {
    this.alertMessage = null;
    this.alertType = null;
  }
}
