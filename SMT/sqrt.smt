(set-logic FP)

; named constants for infinities, +-0, and NaN
(define-const plusinf Float32 (_ +oo 8 24))
(define-const minusinf Float32 (_ -oo 8 24))
(define-const pluszero Float32 (_ +zero 8 24))
(define-const minuszero Float32 (_ -zero 8 24))
(define-const nanvalue Float32 (_ NaN 8 24))

; named constant for argument to sqrt
(declare-const x Float32)

; other useful constants
(define-const plus_one Float32 ((_ to_fp 8 24) RNE 1.0))
(define-const epsilon Float32 ((_ to_fp 8 24) RNE 0.00001))

(push)
(assert (not (fp.isNaN (fp.sqrt RNE nanvalue))))
(check-sat)
(pop)

; other properties require x not NaN
(assert (not (fp.isNaN x)))

(push)
(assert (fp.eq x plusinf))
(assert (not (fp.eq (fp.sqrt RNE x) plusinf)))
(check-sat)
(pop)

(push)
(assert (= x pluszero))
(assert (not (= (fp.sqrt RNE x) pluszero)))
(check-sat)
(pop)

(push)
(assert (= x minuszero))
(assert (not (= (fp.sqrt RNE x) minuszero)))
(check-sat)
(pop)

(push)
(assert (fp.lt x minuszero))
(assert (not (fp.isNaN (fp.sqrt RNE x))))
(check-sat)
(pop)

(push)
(assert (fp.gt x pluszero))
(assert (not (fp.gt (fp.sqrt RNE x) pluszero)))
(check-sat)
(pop)

(assert (fp.gt x pluszero))
(assert (fp.lt x plus_one))
(assert (not (fp.gt (fp.sqrt RNE x) (fp.sub RNE x epsilon))))
(check-sat)
(exit)
