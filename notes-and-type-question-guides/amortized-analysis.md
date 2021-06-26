# Amortized analysis - notes

Amortised time.
Discribing an average time for a single operation,
from a sequence of operations,
where the sequence is chosen to maximize time.

Some operations may take more or less time.

For a sequence of k operations op,
where the sequence is chosen to maximize,
the sum of T(op_k),
dividing by k gives the (amortised) average time for 1 operation.