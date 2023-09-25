import React from "react";
import * as Yup from "yup";
import {ErrorMessage, Field, Form, Formik} from "formik";
import {Link, useNavigate} from "react-router-dom";
import AuthHeader from "../../components/general/AuthHeader";
import {AiOutlineArrowLeft, AiOutlineArrowRight} from "react-icons/ai";

export default function ResetPassword() {
    const initialValues = {
        email: ''
    };

    const validationSchema = Yup.object().shape({
        email: Yup.string()
            .required('Email is required')
            .email('Invalid email')
    });

    const handleSubmit = (values) => {
        alert(JSON.stringify(values));
    };

    const navigate = useNavigate();
    const goBack = () => {
        navigate(-1);
    }

    return (
        <div className={'container'}>

            <div className={'main-container'}>
                <AuthHeader/>

                <div className={'form-container'}>

                    <h1 className={'form-title'}>Reset password</h1>

                    <Formik
                        initialValues={initialValues}
                        validationSchema={validationSchema}
                        onSubmit={handleSubmit}
                    >
                        {({values, errors, touched, isValid, dirty}) => (
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

                                <button type={'submit'}
                                        disabled={!(dirty && isValid)}
                                        className={'btn btn-primary base-btn'}>
                                    Send link
                                    <AiOutlineArrowRight className={'icon'}/>
                                </button>

                                <button onClick={goBack}
                                        className={'btn btn-outline-success base-btn'}>
                                    <AiOutlineArrowLeft className={'icon'}/>
                                    Back
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

        </div>
    )
}