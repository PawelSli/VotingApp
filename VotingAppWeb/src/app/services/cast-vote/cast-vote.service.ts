import {Injectable} from '@angular/core';
import {Candidate, Voter} from "../../models/models";
import {Observable} from 'rxjs';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class CastVoteService {

  constructor(private http: HttpClient) {
  }

  fetchVoters(): Observable<Voter[]> {
    return this.http.get<Voter[]>(`${environment.apiUrl}/voters`);
  }

  fetchCandidates(): Observable<Candidate[]> {
    return this.http.get<Candidate[]>(`${environment.apiUrl}/candidates`);
  }

  submitVote(voterId: number | null, candidateId: number | null): Observable<string> {
    const votePayload = {voterId, candidateId};
    return this.http.post<string>(`${environment.apiUrl}/votes`, votePayload, {responseType: 'text' as 'json'});
  }
}
