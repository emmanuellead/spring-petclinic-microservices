DROP TABLE ratings IF EXISTS;

CREATE TABLE ratings (
  id          INTEGER IDENTITY PRIMARY KEY,
  visit_id      INTEGER NOT NULL,
  vet_id       INTEGER NOT NULL,
  stars INTEGER NOT NULL CHECK (stars >= 1 AND stars <= 5),
  comment VARCHAR(8192)
);

CREATE INDEX ratings_visit_id ON ratings (visit_id);
CREATE INDEX ratings_vet_id ON ratings (vet_id);
