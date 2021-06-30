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
(assert (fp.isNaN (fp.max x nan_value)))
(check-sat)
(pop)

(push)
(assert (not (fp.isNaN y)))
(assert (fp.isNaN (fp.max nan_value y)))
(check-sat)
(pop)

(push)
(assert (not (fp.isNaN x)))
(assert (not (fp.eq (fp.max x nan_value) x)))
(check-sat)
(pop)

(push)
(assert (not (fp.isNaN y)))
(assert (not (fp.eq (fp.max nan_value y) y)))
(check-sat)
(pop)

; remaining properties assume no NaNs
(assert (not (fp.isNaN x)))
(assert (not (fp.isNaN y)))

(push)
(assert (fp.eq x plus_inf))
(assert (not (fp.eq (fp.max x y) plus_inf)))
(check-sat)
(pop)

(push)
(assert (fp.eq x minus_inf))
(assert (not (fp.eq (fp.max x y) y)))
(check-sat)
(pop)

(push)
(assert (fp.eq (fp.max x plus_one) plus_one))
(assert (fp.eq (fp.max x y) x))
(assert (not (fp.eq (fp.max y plus_one) plus_one)))
(check-sat)
(pop)

(push)
(assert (fp.eq (fp.max x plus_one) plus_one))
(assert (fp.eq (fp.max x y) x))
(assert (not (fp.leq y plus_one)))
(check-sat)
(pop)

(push)
(declare-const z Float32)
(assert (not (fp.isNaN z)))
(assert (fp.eq (fp.max x y) x))
(assert (fp.eq (fp.max y z) y))
(push)
  (assert (not (fp.eq (fp.max x z) x)))
  (check-sat)
(pop)
(push)
  (assert (not (fp.leq z x)))
  (check-sat)
(pop)


(exit)
