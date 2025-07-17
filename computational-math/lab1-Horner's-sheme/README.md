# Horner's sheme
- It's used to iteratively solve polynomials.
- For example we have P(x) = a0x^n + a1x^(n-1) + ... + an. We can rewrite it as P(x) = ((a0x + a1)x + a2)x + ... + an. a0,...,an - constant coefficients.
- b0 = a0
- c1 = b0x;  b1 = a1 + c1
- c2 = b1x;  b2 = a2 + c2
- ...
- cn = b(n-1)x;  bn = an + cn
- P(x) = bn
- So we can easily solve any polynomial iteratively doing simple operations.
