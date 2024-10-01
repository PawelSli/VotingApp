import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Candidate, Voter} from "../../models/models";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class StatisticsService {

  constructor(private http: HttpClient) {
  }

  fetchVoters(): Observable<Voter[]> {
    return this.http.get<Voter[]>(`${environment.apiUrl}/voters`);
  }

  fetchCandidates(): Observable<Candidate[]> {
    return this.http.get<Candidate[]>(`${environment.apiUrl}/candidates`);
  }

  addVoter(voter: { name: string, hasVoted: boolean }): Observable<any> {
    return this.http.post(`${environment.apiUrl}/voters`, voter);
  }

  addCandidate(candidate: { name: string, votes: number }): Observable<any> {
    return this.http.post(`${environment.apiUrl}/candidates`, candidate);
  }
}
