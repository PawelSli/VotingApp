CREATE TABLE candidates
(
    candidate_id SERIAL PRIMARY KEY,
    name         VARCHAR(100) NOT NULL,
    votes        INTEGER DEFAULT 0
);
