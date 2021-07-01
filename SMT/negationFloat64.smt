(set-logic FP)

; named constants for infinities, +-0, and NaN
(define-const plusinf Float64 (_ +oo 11 53))
(define-const minusinf Float64 (_ -oo 11 53))
(define-const pluszero Float64 (_ +zero 11 53))
(define-const minuszero Float64 (_ -zero 11 53))
(define-const nanvalue Float64 (_ NaN 11 53))

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

(declare-const x Float64)
(assert (fp.geq x pluszero))
(define-fun negation_variable () Bool
(fp.eq (fp.neg x) (fp.mul RNE ((_ to_fp 11 53) RNE -1.0) x)))

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
