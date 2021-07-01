(set-logic FP)

; Tests for multiplication for floating point in z3

(define-const plusinf Float64 (_ +oo 11 53))
(define-const minusinf Float64 (_ -oo 11 53))
(define-const pluszero Float64 (_ +zero 11 53))
(define-const minuszero Float64 (_ -zero 11 53))
(define-const nanvalue Float64 (_ NaN 11 53))

; functions for testing constant values
(define-fun multiplication_nan_nan () Bool
(fp.isNaN (fp.mul RNE nanvalue nanvalue)))

(define-fun multiplication_nan_real () Bool
(fp.isNaN (fp.mul RNE nanvalue pluszero)))

(define-fun multiplication_nan_nonreal () Bool
(fp.isNaN (fp.mul RNE nanvalue plusinf)))

(define-fun multiplication_pluszero_pluszero () Bool
(fp.eq (fp.mul RNE pluszero pluszero) pluszero))

(define-fun multiplication_pluszero_minuszero () Bool
(fp.eq (fp.mul RNE pluszero minuszero) minuszero))

(define-fun multiplication_minuszero_minuszero () Bool
(fp.eq (fp.mul RNE minuszero minuszero) pluszero))

(define-fun multiplication_plusinf_plusinf () Bool
(fp.eq (fp.mul RNE plusinf plusinf) plusinf))

(define-fun multiplication_plusinf_minusinf () Bool
(fp.eq (fp.mul RNE plusinf minusinf) minusinf))

(define-fun multiplication_minusinf_minusinf () Bool
(fp.eq (fp.mul RNE minusinf minusinf) plusinf))

(push)
(echo "multiplication nan with nan")
(assert (not multiplication_nan_nan))
(check-sat)
(echo "")
(pop)

(push)
(echo "multiplication nan with real")
(assert (not multiplication_nan_real))
(check-sat)
(echo "")
(pop)

(push)
(echo "multiplication nan with nonreal")
(assert (not multiplication_nan_nonreal))
(check-sat)
(echo "")
(pop)

(push)
(echo "multiplication pluszero with pluszero")
(assert (not multiplication_pluszero_pluszero))
(check-sat)
(echo "")
(pop)

(push)
(echo "multiplication pluszero with minuszero")
(assert (not multiplication_pluszero_minuszero))
(check-sat)
(echo "")
(pop)

(push)
(echo "multiplication minuszero with minuszero")
(assert (not multiplication_minuszero_minuszero))
(check-sat)
(echo "")
(pop)

(push)
(echo "multiplication plusinf with plusinf")
(assert (not multiplication_plusinf_plusinf))
(check-sat)
(echo "")
(pop)

(push)
(echo "multiplication plusinf with minusinf")
(assert (not multiplication_plusinf_plusinf))
(check-sat)
(echo "")
(pop)

(push)
(echo "multiplication minusinf with minusinf")
(assert (not multiplication_minusinf_minusinf))
(check-sat)
(echo "")
(pop)
