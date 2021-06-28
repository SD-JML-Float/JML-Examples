(set-logic FP)

; Tests for float 64 (double) absolute value operation

(define-const plusinf Float64 (_ +oo 11 53))
(define-const minusinf Float64 (_ -oo 11 53))
(define-const pluszero Float64 (_ +zero 11 53))
(define-const minuszero Float64 (_ -zero 11 53))
(define-const nanvalue Float64 (_ NaN 11 53))

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
(declare-const x Float64)
(assert (fp.geq x pluszero))
(define-fun abs_neg () Bool
(fp.eq (fp.abs (fp.neg x)) x))

; check abs functionality with NaN
(push)
(echo "abs NaN property")
(assert (not abs_nan))
(check-sat)
(echo "") ; insert newline
(pop)

; check abs functionality with positive infinity
(push)
(echo "abs positive infinity property")
(assert (not abs_plusinf))
(check-sat)
(echo "") ; insert newline
(pop)

; check abs functionality with negative infinity
(push)
(echo "abs negative infinity property")
(assert (not abs_minusinf))
(check-sat)
(echo "") ; insert newline
(pop)

; check abs functionality with variables
(push)
(echo "abs with variables")
(assert (not abs_neg))
(check-sat)
(echo "") ; insert newline
(pop)

(exit)
