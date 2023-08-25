import React from "react"

function Login(props) {
    return (
        <div className="form-container">
            <form className="form">

                <h1 className="form-title">Welcome back!</h1>
                <p className="form-subtitle">Log in to your account.</p>

                <div className="form-group mt-3">
                    <label>Email address</label>
                    <input
                        type="email"
                        className="form-control mt-1"
                        placeholder="Enter email"
                        required
                    />
                </div>

                <div className="form-group mt-3">
                    <label>Password</label>
                    <input
                        type="password"
                        className="form-control mt-1"
                        placeholder="Enter password"
                        required
                    />
                </div>

                <div className="row mt-2">
                    <div className="col-4">
                        <input className="form-check-input"
                               type="checkbox"/>
                        <label className="remember-me text-right">Remember me</label>
                    </div>

                    <div className="col-4">
                        <p className="forgot-password">
                            <a href="#">Fogot password?</a>
                        </p>
                    </div>

                </div>

                <div className="d-grid gap-2 ">
                    <button type="submit"
                            className="btn btn-primary">
                        Contune
                    </button>
                </div>

            </form>

            <p className="forgot-password">
                New here?<a href="#">Create your account now</a>
            </p>

        </div>
    )
}

export default Login