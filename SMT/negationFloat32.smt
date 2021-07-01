(set-logic FP)

; Checks the floating point negation operation in z3

; named constants for infinities, +-0, and NaN
(define-const plusinf Float32 (_ +oo 8 24))
(define-const minusinf Float32 (_ -oo 8 24))
(define-const pluszero Float32 (_ +zero 8 24))
(define-const minuszero Float32 (_ -zero 8 24))
(define-const nanvalue Float32 (_ NaN 8 24))

(define-fun negation_nan () Bool
(fp.isNaN (fp.neg nanvalue)))

(define-fun negation_pluszero () Bool
(fp.eq (fp.neg pluszero) minuszero))

(define-fun negation_minuszero () Bool
(fp.eq (fp.neg minuszero) pluszero))

(define-fun negation_plusinf () Bool
(fp.eq (fp.neg plusinf) minusinf))

(define-fun negation_minusinf () Bool
(fp.eq (fp.neg minusinf) plusinf))

(declare-const x Float32)
(assert (fp.geq x pluszero))
(define-fun negation_variable () Bool
(fp.eq (fp.neg x) (fp.mul RNE ((_ to_fp 8 24) RNE -1.0) x)))

(push)
(echo "negation nan property")
(assert (not negation_nan))
(check-sat)
(echo "")
(pop)

(push)
(echo "negation pluszero property")
(assert (not negation_pluszero))
(check-sat)
(echo "")
(pop)

(push)
(echo "negation minuszero property")
(assert (not negation_minuszero))
(check-sat)
(echo "")
(pop)

(push)
(echo "negation plusinf property")
(assert (not negation_plusinf))
(check-sat)
(echo "")
(pop)

(push)
(echo "negation minusinf property")
(assert (not negation_minusinf))
(check-sat)
(echo "")
(pop)

(push)
(echo "negation variable property")
(assert (not negation_variable))
(check-sat)
(echo "")
(pop)
