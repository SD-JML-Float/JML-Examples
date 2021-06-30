(set-logic FP)

; named constants for infinities, +-0, and NaN
(define-const plus_inf Float32 (_ +oo 8 24))
(define-const minus_inf Float32 (_ -oo 8 24))
(define-const plus_zero Float32 (_ +zero 8 24))
(define-const minus_zero Float32 (_ -zero 8 24))
(define-const nan_value Float32 (_ NaN 8 24))

; named constant for argument to rint
(declare-const x Float32)
(declare-const y Float32)

; other useful constants
(define-const plus_one Float32 ((_ to_fp 8 24) RNE 1.0))
(define-const minus_one Float32 ((_ to_fp 8 24) RNE -1.0))
(define-const epsilon Float32 ((_ to_fp 8 24) RNE 0.00001))

(define-fun approx_equal ((a Float32) (b Float32)) Bool
(and (fp.geq a (fp.sub RNE b epsilon)) (fp.leq a (fp.add RNE b epsilon))))

(push)
(assert (not (fp.isNaN x)))
(assert (fp.isNaN (fp.min x nan_value)))
(check-sat)
(pop)

(push)
(assert (not (fp.isNaN y)))
(assert (fp.isNaN (fp.min nan_value y)))
(check-sat)
(pop)

(push)
(assert (not (fp.isNaN x)))
(assert (not (fp.eq (fp.min x nan_value) x)))
(check-sat)
(pop)

(push)
(assert (not (fp.isNaN y)))
(assert (not (fp.eq (fp.min nan_value y) y)))
(check-sat)
(pop)

(assert (not (fp.isNaN x)))
(assert (not (fp.isNaN y)))

(push)
(assert (fp.eq x minus_inf))
(assert (not(fp.eq (fp.min x y) minus_inf)))
(check-sat)
(pop)

(push)
(assert (fp.eq (fp.min x plus_one) plus_one))
(assert (fp.eq (fp.min x y) x))
(assert (not (fp.eq (fp.min y plus_one) plus_one)))
(check-sat)
(pop)

(push)
(assert (fp.eq (fp.min x plus_one) plus_one))
(assert (fp.eq (fp.min x y) x))
(assert (not (fp.geq y plus_one)))
(check-sat)
(pop)

(exit)
