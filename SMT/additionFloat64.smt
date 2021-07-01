(set-logic FP)

; checks the addition properties of floating points within z3

; named constants for infinities, +-0, and NaN
(define-const plusinf Float64 (_ +oo 11 53))
(define-const minusinf Float64 (_ -oo 11 53))
(define-const pluszero Float64 (_ +zero 11 53))
(define-const minuszero Float64 (_ -zero 11 53))
(define-const nanvalue Float64 (_ NaN 11 53))

; Functions to test special constants
(define-fun addition_nan_nan () Bool
(fp.isNaN (fp.add RNE nanvalue nanvalue)))

(define-fun addition_nan_real () Bool
(fp.isNaN (fp.add RNE nanvalue pluszero)))

(define-fun addition_nan_nonreal () Bool
(fp.isNaN (fp.add RNE nanvalue plusinf)))

(define-fun addition_pluszero_pluszero () Bool
(fp.eq (fp.add RNE pluszero pluszero) pluszero))

(define-fun addition_minuszero_minuszero () Bool
(fp.eq (fp.add RNE minuszero minuszero) minuszero))

(define-fun addition_plusinf_plusinf () Bool
(fp.eq (fp.add RNE plusinf plusinf) plusinf))

(define-fun addition_plusinf_real () Bool
(fp.eq (fp.add RNE plusinf pluszero) plusinf))

(define-fun addition_plusinf_nonreal () Bool
(fp.eq (fp.add RNE plusinf plusinf) plusinf))

(define-fun addition_minusinf_minusinf () Bool
(fp.eq (fp.add RNE minuszero minusinf) minusinf))

; check functionality with nan added to nan
(push)
(echo "nan added to nan property")
(assert (not addition_nan_nan))
(check-sat)
(echo "")
(pop)

; check functionality with nan added to a real number
(push)
(echo "nan added to real number property")
(assert (not addition_nan_real))
(check-sat)
(echo "")
(pop)

; check functionality with nan added to a nonreal number
(push)
(echo "nan added to nonreal number property")
(assert (not addition_nan_nonreal))
(check-sat)
(echo "")
(pop)

; check functionality with pluszero added with pluszero
(push)
(echo "pluszero added to pluszero property")
(assert (not addition_pluszero_pluszero))
(check-sat)
(echo "")
(pop)

; check functionality with minuszero added with minuszero
(push)
(echo "minuszero added to minuszero property")
(assert (not addition_minuszero_minuszero))
(check-sat)
(echo "")
(pop)

; check functionality with plusinf added with plusinf
(push)
(echo "plusinf added to plusinf property")
(assert (not addition_plusinf_plusinf))
(check-sat)
(echo "")
(pop)

; check functionality with plusinf added with real number
(push)
(echo "plusinf added to real property")
(assert (not addition_plusinf_real))
(check-sat)
(echo "")
(pop)

; check functionality with plusinf added with nonreal number
(push)
(echo "plusinf added to nonreal property")
(assert (not addition_plusinf_nonreal))
(check-sat)
(echo "")
(pop)

; check functinality with minusinf added with minusinf
(push)
(echo "minusinf added to minusinf property")
(assert (not addition_minusinf_minusinf))
(check-sat)
(echo "")
(pop)
