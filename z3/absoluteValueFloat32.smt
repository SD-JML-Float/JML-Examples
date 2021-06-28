(set-logic FP)

; named constants for infinities, +-0, and NaN
(define-const plusinf Float32 (_ +oo 8 24))
(define-const minusinf Float32 (_ -oo 8 24))
(define-const pluszero Float32 (_ +zero 8 24))
(define-const minuszero Float32 (_ -zero 8 24))
(define-const nanvalue Float32 (_ NaN 8 24))

; named functions corresponding to each property asserted
; specify behavior on all special values
(define-fun abs_nan () Bool
(fp.isNaN (fp.abs nanvalue)))

(define-fun abs_plusinf () Bool
(fp.eq (fp.abs plusinf) plusinf))

(define-fun abs_minusinf () Bool
(fp.eq (fp.abs minusinf) plusinf))


; specify other properties and general behavior
; eg abs(-x) = x when x >= 0
(declare-const x Float32)
(assert (fp.geq x pluszero))
(define-fun abs_neg () Bool
(fp.eq (fp.abs (fp.neg x)) x))


; check abs functionality with NaN
(push)
(echo "abs NaN property")
(assert (not abs_nan))
(check-sat)
(echo "")
(pop)

(push)
(echo "abs positive infinity property")
(assert (not abs_plusinf))
(check-sat)
(echo "")
(pop)

(push)
(echo "abs negative infinity property")
(assert (not abs_minusinf))
(check-sat)
(echo "")
(pop)

(push)
(echo "abs with variables property")
(assert (not abs_neg))
(check-sat)

(exit)
