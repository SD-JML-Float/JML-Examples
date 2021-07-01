(set-logic FP)

; checks the subtraction property of floating points within z3

; named constants for infinities, +-0, and NaN
(define-const plusinf Float64 (_ +oo 11 53))
(define-const minusinf Float64 (_ -oo 11 53))
(define-const pluszero Float64 (_ +zero 11 53))
(define-const minuszero Float64 (_ -zero 11 53))
(define-const nanvalue Float64 (_ NaN 11 53))

; Functions to test special constants
(define-fun subtraction_nan_nan () Bool
(fp.isNaN (fp.sub RNE nanvalue nanvalue)))

(define-fun subtraction_nan_real () Bool
(fp.isNaN (fp.sub RNE nanvalue pluszero)))

(define-fun subtraction_nan_nonreal () Bool
(fp.isNaN (fp.sub RNE nanvalue plusinf)))

(define-fun subtraction_pluszero_pluszero () Bool
(fp.eq (fp.sub RNE pluszero pluszero) pluszero))

(define-fun subtraction_minuszero_minuszero () Bool
(fp.eq (fp.sub RNE minuszero minuszero) minuszero))

(define-fun subtraction_plusinf_plusinf () Bool
(fp.eq (fp.sub RNE plusinf plusinf) plusinf))

(define-fun subtraction_plusinf_real () Bool
(fp.eq (fp.sub RNE plusinf pluszero) plusinf))

(define-fun subtraction_plusinf_nonreal () Bool
(fp.eq (fp.sub RNE plusinf minusinf) plusinf))

(define-fun subtraction_minusinf_minusinf () Bool
(fp.eq (fp.sub RNE minusinf minusinf) minusinf))

(define-fun subtraction_minusinf_real () Bool
(fp.eq (fp.sub RNE minusinf pluszero) minusinf))

(define-fun subtraction_minusinf_nonreal () Bool
(fp.eq (fp.sub RNE minusinf plusinf) minusinf))

(push)
(echo "nan subracted from nan property")
(assert (not subtraction_nan_nan))
(check-sat)
(echo "")
(pop)

(push)
(echo "nan subtracted from real number property")
(assert (not subtraction_nan_real))
(check-sat)
(echo "")
(pop)

(push)
(echo "nan subtracted from nonreal number property")
(assert (not subtraction_nan_nonreal))
(check-sat)
(echo "")
(pop)

(push)
(echo "pluszero subtracted from pluszero property")
(assert (not subtraction_pluszero_pluszero))
(check-sat)
(echo "")
(pop)

(push)
(echo "minuszero subtracted from minuszero property")
(assert (not subtraction_minuszero_minuszero))
(check-sat)
(echo "")
(pop)

(push)
(echo "plusinf subtracted from plusinf property")
(assert (not subtraction_plusinf_plusinf))
(check-sat)
(echo "")
(pop)

(push)
(echo "plusinf subtacted from real property")
(assert (not subtraction_plusinf_real))
(check-sat)
(echo "")
(pop)

(push)
(echo "plusinf subtracted from nonreal property")
(assert (not subtraction_plusinf_nonreal))
(check-sat)
(echo "")
(pop)

(push)
(echo "minusinf subtracted from minusinf property")
(assert (not subtraction_minusinf_minusinf))
(check-sat)
(echo "")
(pop)

(push)
(echo "minusinf subtracted from real property")
(assert (not subtraction_minusinf_real))
(check-sat)
(echo "")
(pop)

(push)
(echo "minusinf subtracted from nonreal property")
(assert (not subtraction_minusinf_nonreal))
(check-sat)
(echo "")
(pop)
