CREATE TABLE voters
(
    voter_id     SERIAL PRIMARY KEY,
    name         VARCHAR(100) NOT NULL,
    candidate_id SERIAL       NOT NULL,
    FOREIGN KEY (candidate_id) REFERENCES candidates (candidate_id)
);
