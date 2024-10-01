export interface Voter {
  voterId: number;
  name: string;
  candidateId: number | null;
}

export interface VoterDisplay {
  name: string;
  hasVoted: boolean
}

export interface Candidate {
  candidateId: number;
  name: string;
  votes: number;
}

export interface CandidateDisplay {
  name: string;
  votes: number;
}
