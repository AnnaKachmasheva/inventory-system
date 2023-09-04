import React from "react"
import {Link} from "react-router-dom";
import {ErrorMessage, Field, Form, Formik} from "formik";
import * as Yup from 'yup';

function Login(props) {

    const initialValues = {
        email: '',
        password: '',
        rememberMe: false
    };

    const validationSchema = Yup.object().shape({
        email: Yup.string()
            .required('Email is required')
            .email('Invalid email'),
        password: Yup.string()
            .required('Password is required')
            .min(8, 'Too short'),
    });

    // const handleSubmit = async (values) => {
    //     try {
    //
    //         const validatedData = await validationSchema.validate(values);
    //
    //
    //         // Send validated data to server
    //         alert(JSON.stringify(validatedData));
    //
    //     } catch (error) {
    //         // Handle validation error
    //     }
    // };

    const handleSubmit = (values) => {

        // if (values.rememberMe) {
        //     localStorage.setItem("rememberMe", values.rememberMe);
        //     localStorage.setItem("email", values.email);
        //     localStorage.setItem("password", values.password);
        //
        //     console.log('localstorage')
        // }

        alert(JSON.stringify(values));
    };

    return (
        <form className={'container w-100'}>

            <div className={'form-container '}>
                <div className={'logo'}>logo</div>

                <div className={'position-relative'}>
                    <div className={'position-relative mt-5 pt-3'}>

                        <h1 className={'form-title'}>Welcome back!</h1>
                        <p className={'form-subtitle pb-2'}>Log in to your account.</p>

                        <Formik
                            initialValues={initialValues}
                            validationSchema={validationSchema}
                            onSubmit={handleSubmit}
                        >
                            {({values, errors, touched}) => (
                                <Form onSubmit={handleSubmit}>

                                    <div className={'form-group p-2'}>
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

                                    <div className="form-group p-2">
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

                                    <div className={'row w-100 mt-1 p-2'}>

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

                                    <div className={'p-2'}>
                                        <button type={'submit'}
                                                className={'btn btn-primary'}>
                                            Contune
                                        </button>
                                    </div>

                                </Form>
                            )}
                        </Formik>
                    </div>
                </div>

                <div className="text-center">
                    <p>
                        New here?
                        <Link to={'/registrtaion'}>Create your account now</Link>
                    </p>
                </div>

            </div>

            <div className={'image-form w-50'}></div>

        </form>
    )
}

export default Login