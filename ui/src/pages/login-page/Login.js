import React from "react"
import {Link} from "react-router-dom";
import {ErrorMessage, Field, Form, Formik} from "formik";
import * as Yup from 'yup';
import {parseJwt, userApi} from "../../services/api";

function Login() {

    const initialValues = {
        email: localStorage.getItem('email') != null ? localStorage.getItem('email') : '',
        password: localStorage.getItem('password') != null ? localStorage.getItem('password') : '',
        rememberMe: localStorage.getItem('rememberMe') != null
    };

    const validationSchema = Yup.object().shape({
        email: Yup.string()
            .required('Email is required')
            .email('Invalid email'),
        password: Yup.string()
            .required('Password is required')
            .min(8, 'Too short'),
    });


    const handleSubmit = async (values) => {
        values.preventDefault();

        const rememberMe = values.rememberMe;
        const email = values.email;
        const password = values.password;

        if (!values.rememberMe) {
            localStorage.clear()
        } else {
            localStorage.setItem("rememberMe", rememberMe);
            localStorage.setItem("email", email);
            localStorage.setItem("password", password);
        }

        try {
            const response = await userApi.login(email, password);
            const {accessToken} = response.data
            const data = parseJwt(accessToken)
            const authenticatedUser = {data, accessToken}
        } catch (error) {
            console.log("log error")

            // todo error handler
            // handlerError(error);
        }
    }

    return (
        <div className={'container'}>

            <div className={'main-container'}>
                <div className={'logo'}>logo</div>

                <div className={'form-container'}>

                    <h1 className={'form-title'}>Welcome back!</h1>
                    <p className={'form-subtitle'}>Log in to your account.</p>

                    <Formik
                        initialValues={initialValues}
                        validationSchema={validationSchema}
                    >
                        {({
                              values,
                              errors,
                              touched,
                              isValid,
                              dirty
                          }) => (
                            <Form onSubmit={handleSubmit}>

                                <div className={'form-group'}>
                                    <label>Email address*</label>
                                    <Field
                                        type={'email'}
                                        className={'form-control '
                                            + (values.email === '' && !touched.email ?
                                                null :
                                                (touched.email && errors.email ?
                                                    'is-invalid' :
                                                    'is-valid'))}
                                        placeholder={'Enter email'}
                                        name={'email'}
                                        required
                                    />
                                    <div className={'invalid-feedback'}>
                                        <ErrorMessage name="email"/>
                                    </div>
                                </div>

                                <div className="form-group">
                                    <label>Password*</label>
                                    <Field
                                        type={'password'}
                                        className={'form-control '
                                            + (values.password === '' && !touched.password ?
                                                null :
                                                (touched.password && errors.password ?
                                                    'is-invalid' :
                                                    'is-valid'))}
                                        placeholder={'Enter password'}
                                        name={'password'}
                                        required
                                    />
                                    <div className={'invalid-feedback'}>
                                        <ErrorMessage name="password"/>
                                    </div>
                                </div>

                                <div className={'row w-100 mt-1'}>
                                    <div className={'col float-start d-inline'}>
                                        <Field className={'form-check-input '}
                                               type={'checkbox'}
                                               name={'rememberMe'}
                                               checked={values.rememberMe}/>
                                        <label className={'remember-me text-right d-inline m-lg-2'}>
                                            Remember me
                                        </label>
                                    </div>

                                    <div className={'col float-end p-0'}>
                                        <p className={'forgot-password text-end'}>
                                            <Link to={'/reset-password'}>
                                                Fogot password?
                                            </Link>
                                        </p>
                                    </div>

                                </div>

                                <button type={'submit'}
                                        disabled={!isValid}
                                        className={'btn btn-primary'}>
                                    Contune
                                </button>
                            </Form>
                        )}
                    </Formik>
                </div>

                <div className="text-center">
                    <p>
                        New here?
                        <Link to={'/registrtaion'}>Create your account now</Link>
                    </p>
                </div>

            </div>

            <div className={'image-form'}></div>

        </div>
    )
}

export default Login