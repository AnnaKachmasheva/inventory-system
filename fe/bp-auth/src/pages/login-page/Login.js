import React, {useState} from "react"
import {Link} from "react-router-dom";

function Login(props) {

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const [error, setError] = useState('');


    return (
        <form className={'container'}>

            <div className={'form-container'}>
                <form className={'form'}>

                    <h1 className={'form-title'}>Welcome back!</h1>
                    <p className={'form-subtitle'}>Log in to your account.</p>

                    <div className={'form-group mt-3'}>
                        <label>Email address</label>
                        <input
                            type={'email'}
                            className={'form-control mt-1'}
                            placeholder={'Enter email'}
                            autoComplete={'email'}
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                            required
                        />
                    </div>

                    <div className="form-group mt-3">
                        <label>Password</label>
                        <input
                            type={'password'}
                            className={'form-control mt-1'}
                            placeholder={'Enter password'}
                            autoComplete={'password'}
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            required
                        />
                    </div>

                    <div className={'row mt-2 w-100'}>
                        <div className={'col-4 float-start'}>
                            <input className={'form-check-input'}
                                   type={'checkbox'}/>
                            <label className={'remember-me text-right'}>
                                Remember me
                            </label>
                        </div>

                        <div className={'col-4 float-end'}>
                            <p className={'forgot-password text-end'}>
                                <Link to={'/reset-password'}>
                                    Fogot password?
                                </Link>
                            </p>
                        </div>

                    </div>


                    <div className={'d-grid gap-2'}>
                        <button type={'submit'}
                                className={'btn btn-primary'}>
                            Contune
                        </button>
                    </div>

                </form>

                <p className="registration">
                    New here?
                    <Link to={'/registrtaion'}>Create your account now</Link>
                </p>

            </div>

            <div className={'image'}></div>

        </form>
    )
}

export default Login