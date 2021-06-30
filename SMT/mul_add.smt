(set-logic FP)

; named constants for infinities, +-0, and NaN
(define-const plusinf Float32 (_ +oo 8 24))
(define-const minusinf Float32 (_ -oo 8 24))
(define-const pluszero Float32 (_ +zero 8 24))
(define-const minuszero Float32 (_ -zero 8 24))
(define-const nanvalue Float32 (_ NaN 8 24))

; 3 constants for the arguments of fused multiply-add
(declare-const x Float32)
(declare-const y Float32)
(declare-const z Float32)

; common conditions on the inputs

(define-fun none_nan () Bool
  (not (or (fp.isNaN x) (fp.isNaN y) (fp.isNaN z))))

(define-fun none_inf () Bool
  (not (or (fp.isInfinite x) (fp.isInfinite y) (fp.isInfinite z))))

(define-fun only_x_inf () Bool
  (and (fp.isInfinite x) (not (fp.isInfinite y)) (not (fp.isInfinite z))))

(define-fun only_y_inf () Bool
  (and (not (fp.isInfinite x)) (fp.isInfinite y) (not (fp.isInfinite z))))

(define-fun only_z_inf () Bool
  (and (not (fp.isInfinite x))  (not (fp.isInfinite y)) (fp.isInfinite z)))

(define-fun all_positive () Bool
  (and (fp.isPositive x) (fp.isPositive y) (fp.isPositive z)))

(define-fun all_negative () Bool
  (and (fp.isNegative x) (fp.isNegative y) (fp.isNegative z)))


; test properties
; any NaN input -> NaN output
(push)
(assert (not none_nan))
(assert (not (fp.isNaN (fp.fma RNE x y z))))
(check-sat)
(pop)

; all other properties require no NaNs
(assert none_nan)

(push)
(assert only_x_inf)
(assert (fp.gt x pluszero))
  (push)
  (assert (fp.gt y pluszero))
  (assert (not (fp.eq (fp.fma RNE x y z) plusinf)))
  (check-sat)
  (pop)
  (push)
  (assert (fp.lt y minuszero))
  (assert (not (fp.eq (fp.fma RNE x y z) minusinf)))
  (check-sat)
  (pop)
(pop)

(push)
(assert only_y_inf)
(assert (fp.gt y pluszero))
(push)
  (assert (fp.gt x pluszero))
  (assert (not (fp.eq (fp.fma RNE x y z) plusinf)))
  (check-sat)
  (pop)
  (push)
  (assert (fp.lt x minuszero))
  (assert (not (fp.eq (fp.fma RNE x y z) minusinf)))
  (check-sat)
  (pop)
(pop)

(push)
(assert only_z_inf)
(assert (not (fp.eq (fp.fma RNE x y z) z)))
(check-sat)
(pop)

; the above are near-instant, this one takes a brief second
(push)
(assert all_positive)
(assert none_inf)
(assert (not (fp.isPositive (fp.fma RNE x y z))))
(check-sat)
(pop)


; these four are slow, ~40 seconds each
(push)
(assert all_negative)
(assert none_inf)
(assert (fp.lt (fp.abs (fp.mul RNE x y)) (fp.abs z)))
(assert (not (fp.isNegative (fp.fma RNE x y z))))
(check-sat)
(pop)

(push)
(assert all_negative)
(assert none_inf)
(assert (fp.gt (fp.abs (fp.mul RNE x y)) (fp.abs z)))
(assert (not (fp.isPositive (fp.fma RNE x y z))))
(check-sat)
(pop)

(push)
(assert (and (fp.isPositive x) (fp.isPositive y) (fp.isNegative z)))
(assert none_inf)
(assert (fp.lt (fp.abs (fp.mul RNE x y)) (fp.abs z)))
(assert (not (fp.isNegative (fp.fma RNE x y z))))
(check-sat)
(pop)

(push)
(assert (and (fp.isPositive x) (fp.isPositive y) (fp.isNegative z)))
(assert none_inf)
(assert (fp.gt (fp.abs (fp.mul RNE x y)) (fp.abs z)))
(assert (not (fp.isPositive (fp.fma RNE x y z))))
(check-sat)
(pop)

(exit)
