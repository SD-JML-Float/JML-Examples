(set-logic FP)

; named constants for infinities, +-0, and NaN
(define-const plus_inf Float32 (_ +oo 8 24))
(define-const minus_inf Float32 (_ -oo 8 24))
(define-const plus_zero Float32 (_ +zero 8 24))
(define-const minus_zero Float32 (_ -zero 8 24))
(define-const nan_value Float32 (_ NaN 8 24))

; named constant for argument to sqrt
(declare-const x Float32)

; other useful constants
(define-const plus_one Float32 ((_ to_fp 8 24) RNE 1.0))
(define-const epsilon Float32 ((_ to_fp 8 24) RNE 0.00001))

(push)
(assert (not (fp.isNaN (fp.sqrt RNE nan_value))))
(check-sat)
(pop)

; other properties require x not NaN
(assert (not (fp.isNaN x)))

(push)
(assert (fp.eq x plus_inf))
(assert (not (fp.eq (fp.sqrt RNE x) plus_inf)))
(check-sat)
(pop)

(push)
(assert (= x plus_zero))
(assert (not (= (fp.sqrt RNE x) plus_zero)))
(check-sat)
(pop)

(push)
(assert (= x minus_zero))
(assert (not (= (fp.sqrt RNE x) minus_zero)))
(check-sat)
(pop)

(push)
(assert (fp.lt x minus_zero))
(assert (not (fp.isNaN (fp.sqrt RNE x))))
(check-sat)
(pop)

(push)
(assert (fp.gt x plus_zero))
(assert (not (fp.gt (fp.sqrt RNE x) plus_zero)))
(check-sat)
(pop)

(assert (fp.gt x plus_zero))
(assert (fp.lt x plus_one))
(assert (not (fp.gt (fp.sqrt RNE x) (fp.sub RNE x epsilon))))
(check-sat)
(exit)
