(set-logic FP)

; named constants for infinities, +-0, and NaN
(define-const plus_inf Float32 (_ +oo 8 24))
(define-const minus_inf Float32 (_ -oo 8 24))
(define-const plus_zero Float32 (_ +zero 8 24))
(define-const minus_zero Float32 (_ -zero 8 24))
(define-const nan_value Float32 (_ NaN 8 24))

; named constant for argument to rint
(declare-const x Float32)

; other useful constants
(define-const plus_one Float32 ((_ to_fp 8 24) RNE 1.0))
(define-const minus_one Float32 ((_ to_fp 8 24) RNE -1.0))
(define-const epsilon Float32 ((_ to_fp 8 24) RNE 0.00001))

(define-fun approx_equal ((a Float32) (b Float32)) Bool
(and (fp.geq a (fp.sub RNE b epsilon)) (fp.leq a (fp.add RNE b epsilon))))

(push)
(assert (not (fp.isNaN (fp.roundToIntegral RNE nan_value))))
(check-sat)
(pop)

(assert (not (fp.isNaN x)))

(push)
(assert (= x plus_inf))
(assert (not (= (fp.roundToIntegral RNE x) plus_inf)))
(check-sat)
(pop)

(push)
(assert (= x minus_inf))
(assert (not (= (fp.roundToIntegral RNE x) minus_inf)))
(check-sat)
(pop)

(push)
(assert (= x minus_zero))
(assert (= (fp.roundToIntegral RNE x) plus_zero))
(check-sat)
(pop)

(push)
(define-const y Float32 (fp.sub RNE x (fp.roundToIntegral RNE x)))
(assert (or (fp.lt y minus_one) (fp.gt y plus_one)))
;(check-sat)
(pop)

(push)
(assert (fp.gt x plus_zero))
(assert (not (fp.geq x plus_zero)))
(check-sat)
(pop)

(push)
(assert (fp.lt x minus_zero))
(assert (not (fp.leq x minus_zero)))
(check-sat)
(pop)

(push)
(define-const y Float32 (fp.roundToIntegral RNE x))
(assert (fp.lt x (fp.add RNE y minus_one)))
(assert (fp.gt x (fp.add RNE y plus_one)))
(check-sat)
(pop)

(push)
(define-const y Float32 (fp.roundToIntegral RNE x))
(assert (fp.lt y (fp.add RNE x minus_one)))
(assert (fp.gt y (fp.add RNE x plus_one)))
(check-sat)

(exit)
