import {Component, OnInit} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from "@angular/forms";
import {Candidate, CandidateDisplay, Voter, VoterDisplay} from "../../models/models";
import {StatisticsService} from "../../services/statistics/statistics.service";

@Component({
  selector: 'app-statistics',
  standalone: true,
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.scss'],
  imports: [CommonModule, FormsModule]
})
export class StatisticsComponent implements OnInit {
  voters: VoterDisplay[] = [];
  candidates: CandidateDisplay[] = [];
  showVoterForm: boolean = false;
  showCandidateForm: boolean = false;
  newVoter = {name: '', hasVoted: false};
  newCandidate = {name: '', votes: 0};

  constructor(private statisticsService: StatisticsService) {
  }

  ngOnInit() {
    this.fetchVoters();
    this.fetchCandidates();
  }

  fetchVoters() {
    this.statisticsService.fetchVoters().subscribe({
      next: (data: Voter[]) => {
        this.voters = data.map(voter => ({
          name: voter.name,
          hasVoted: voter.candidateId !== null,
        }));
      },
      error: (error) => {
        console.error('Error fetching voters', error);
      }
    });
  }

  fetchCandidates() {
    this.statisticsService.fetchCandidates().subscribe({
      next: (data: Candidate[]) => {
        this.candidates = data;
      },
      error: (error) => {
        console.error('Error fetching candidates', error);
      }
    });
  }

  addVoter() {
    this.statisticsService.addVoter(this.newVoter).subscribe(() => {
      this.voters.push({...this.newVoter});
      this.newVoter = {name: '', hasVoted: false};
      this.showVoterForm = false;
      this.fetchVoters();
    });
  }

  addCandidate() {
    this.statisticsService.addCandidate(this.newCandidate).subscribe(() => {
      this.candidates.push({...this.newCandidate});
      this.newCandidate = {name: '', votes: 0};
      this.showCandidateForm = false;
      this.fetchCandidates();
    });
  }
}
