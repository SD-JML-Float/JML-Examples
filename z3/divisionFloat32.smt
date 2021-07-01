(set-logic FP)

; Script to test division operation with floating points

; named constants for infinities, +-0, and NaN
(define-const plusinf Float32 (_ +oo 8 24))
(define-const minusinf Float32 (_ -oo 8 24))
(define-const pluszero Float32 (_ +zero 8 24))
(define-const minuszero Float32 (_ -zero 8 24))
(define-const nanvalue Float32 (_ NaN 8 24))

; functions to test float point constants
(define-fun division_nan_nan () Bool
(fp.isNaN (fp.div RNE nanvalue nanvalue)))

(define-fun division_nan_real () Bool
(fp.isNaN (fp.div RNE nanvalue pluszero)))

(define-fun division_nan_nonreal () Bool
(fp.isNaN (fp.div RNE nanvalue plusinf)))

(define-fun division_pluszero_pluszero () Bool
(fp.isNaN (fp.div RNE pluszero pluszero)))

(define-fun division_pluszero_minuszero () Bool
(fp.isNaN (fp.div RNE pluszero minuszero)))

(define-fun division_minuszero_minuszero () Bool
(fp.isNaN (fp.div RNE minuszero minuszero)))

(define-fun division_plusinf_pluszero () Bool
(fp.eq (fp.div RNE plusinf pluszero) plusinf))

(define-fun division_plusinf_minuszero () Bool
(fp.eq (fp.div RNE plusinf minuszero) minusinf))

(define-fun division_minusinf_pluszero () Bool
(fp.eq (fp.div RNE minusinf pluszero) minusinf))

(define-fun division_minusinf_minuszero () Bool
(fp.eq (fp.div RNE minusinf minuszero) plusinf))

(define-fun division_plusinf_plusinf () Bool
(fp.isNaN (fp.div RNE plusinf plusinf)))

(define-fun division_plusinf_minusinf () Bool
(fp.isNaN (fp.div RNE plusinf minusinf)))

(define-fun division_minusinf_minusinf () Bool
(fp.isNaN (fp.div RNE minusinf minusinf)))

(push)
(echo "dividing nan by nan")
(assert (not division_nan_nan))
(check-sat)
(echo "")
(pop)

(push)
(echo "dividing nan by real")
(assert (not division_nan_real))
(check-sat)
(echo "")
(pop)

(push)
(echo "dividing nan by nonreal")
(assert (not division_nan_nonreal))
(check-sat)
(echo "")
(pop)

(push)
(echo "dividing pluszero by pluszero")
(assert (not division_pluszero_pluszero))
(check-sat)
(echo "")
(pop)

(push)
(echo "dividing pluszero by minuszero")
(assert (not division_pluszero_minuszero))
(check-sat)
(echo "")
(pop)

(push)
(echo "dividing minuszero by minuszero")
(assert (not division_minuszero_minuszero))
(check-sat)
(echo "")
(pop)

(push)
(echo "dividing plusinf by pluszero")
(assert (not division_plusinf_pluszero))
(check-sat)
(echo "")
(pop)

(push)
(echo "dividing plusinf by minuszero")
(assert (not division_plusinf_minuszero))
(check-sat)
(echo "")
(pop)

(push)
(echo "dividing minusinf by pluszero")
(assert (not division_minusinf_pluszero))
(check-sat)
(echo "")
(pop)

(push)
(echo "dividing minusinf by minuszero")
(assert (not division_minusinf_minuszero))
(check-sat)
(echo "")
(pop)

(push)
(echo "dividing plusinf by plusinf")
(assert (not division_plusinf_plusinf))
(check-sat)
(echo "")
(pop)

(push)
(echo "dividing plusinf by minusinf")
(assert (not division_plusinf_minusinf))
(check-sat)
(echo "")
(pop)

(push)
(echo "dividing minusinf by minusinf")
(assert (not division_minusinf_minusinf))
(check-sat)
(echo "")
(pop)
