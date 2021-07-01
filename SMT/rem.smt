(set-logic FP)

; named constants for infinities, +-0, and NaN
(define-const plus_inf Float32 (_ +oo 8 24))
(define-const minus_inf Float32 (_ -oo 8 24))
(define-const plus_zero Float32 (_ +zero 8 24))
(define-const minus_zero Float32 (_ -zero 8 24))
(define-const nan_value Float32 (_ NaN 8 24))

; named constants for arguments to rem
(declare-const x Float32)
(declare-const y Float32)

; other useful constants
(define-const plus_one Float32 ((_ to_fp 8 24) RNE 1.0))
(define-const minus_one Float32 ((_ to_fp 8 24) RNE -1.0))
(define-const epsilon Float32 ((_ to_fp 8 24) RNE 0.00001))

(define-fun approx_equal ((a Float32) (b Float32)) Bool
(and (fp.geq a (fp.sub RNE b epsilon)) (fp.leq a (fp.add RNE b epsilon))))

(push)
(assert (not (fp.isNaN (fp.rem nan_value y))))
(check-sat)
(pop)

(push)
(assert (not (fp.isNaN (fp.rem x nan_value))))
(check-sat)
(pop)

; remaining properties require no NaNs
(assert (not (fp.isNaN x)))
(assert (not (fp.isNaN y)))
(push)

(assert (= x plus_inf))
(assert (not (= (fp.rem x y) nan_value)))
(check-sat)
(pop)

(push)
(assert (= y plus_inf))
(assert (not (fp.isInfinite x)))
(assert (not (= (fp.rem x y) x)))
(check-sat)
(pop)

(push)
(assert (= y plus_inf))
(assert (= x plus_inf))
(assert (not (fp.isNaN (fp.rem x y))))
(check-sat)
(pop)

; remaining properties require no infinities
(assert (not (fp.isInfinite x)))
(assert (not (fp.isInfinite y)))
(push)

(assert (fp.eq y plus_one))
(assert (not (fp.lt (fp.rem x y) plus_one)))
(check-sat)
(pop)

(push)
(assert (fp.gt x plus_zero))
(assert (fp.lt x plus_one))
(assert (fp.eq y plus_one))
(assert (not (fp.gt (fp.rem x y) minus_one)))
(check-sat)

(exit)
