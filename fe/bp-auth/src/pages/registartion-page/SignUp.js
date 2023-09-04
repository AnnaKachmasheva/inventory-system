import React, {useState} from "react"
import {Link} from "react-router-dom";
import {ErrorMessage, Field, Form, Formik} from "formik";
import * as Yup from 'yup';
import {BsCheckCircle} from "react-icons/bs";
import classnames from 'classnames';


function SignUp(props) {

    const initialValues = {
        firstName: '',
        lastName: '',
        email: '',
        password: '',
        repeatPassword: ''
    };


    const validationSchema = Yup.object().shape({
        email: Yup.string()
            .required('Email is required')
            .email('Invalid email'),
        password: Yup.string()
            .required('Password is required'),
        repeatPassword: Yup.string()
            .required('Repeat password is required')
            .oneOf([Yup.ref("password"), null], "Password must match")
    });


    const [min8Characters, setMin8Characters] = useState(false)
    const [hasNumber, setHasNumber] = useState(false)
    const [hasLowercaseLetter, setHasLowercaseLetter] = useState(false)
    const [hasUppercaseLetter, setHasUppercaseLetter] = useState(false)
    const [hasSymbol, setHasSymbol] = useState(false)

    const [twoConditionsForPassword, setTwoConditionsForPassword] = useState(false)
    const [fourConditionsForPassword, setFourConditionsForPassword] = useState(false)
    const [fiveConditionsForPassword, setFiveConditionsForPassword] = useState(false)


    const handleChangePassword = (e) => {
        const password = e.target.value;

        const passwordHasMin8Characters = password.length > 7;
        setMin8Characters(passwordHasMin8Characters);

        const passwordHasNumber = /[0-9]/.test(password);
        setHasNumber(passwordHasNumber);

        const passwordHasLowCaseLetter = /[a-z]/.test(password);
        setHasLowercaseLetter(passwordHasLowCaseLetter);

        const passwordHasUpperCaseLetter = /[[A-Z]/.test(password);
        setHasUppercaseLetter(passwordHasUpperCaseLetter);

        const passwordHasSymbol = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]/.test(password);
        setHasSymbol(passwordHasSymbol);

        let countConditions = 0;
        countConditions += passwordHasMin8Characters ? 1 : 0;
        countConditions += passwordHasNumber ? 1 : 0;
        countConditions += passwordHasLowCaseLetter ? 1 : 0;
        countConditions += passwordHasUpperCaseLetter ? 1 : 0;
        countConditions += passwordHasSymbol ? 1 : 0;

        setTwoConditionsForPassword(countConditions >= 2);
        setFourConditionsForPassword(countConditions >= 4);
        setFiveConditionsForPassword(countConditions >= 5);

    }

    const handleSubmit = async (values) => {
        try {
            const validatedData = await validationSchema.validate(values);

            // Send validated data to server
            alert(JSON.stringify(values));

        } catch (error) {
            // Handle validation error
        }
    };


    return (
        <form className={'container w-100'}>

            <div className={'form-container'}>
                <div className={'logo'}>logo</div>

                <div className={'position-relative'}>
                    <div className={'position-relative mt-5 pt-3'}>

                        <h1 className={'form-title pb-2'}>Registartion</h1>

                        <Formik
                            initialValues={initialValues}
                            validationSchema={validationSchema}
                            onSubmit={handleSubmit}
                        >
                            {({values, errors, touched}) => (
                                <Form onSubmit={handleSubmit}>

                                    <div className={'form-group p-2'}>
                                        <label>First name</label>
                                        <Field
                                            type={'text'}
                                            className={'form-control '
                                                + (values.firstName === '' && !touched.firstName ?
                                                    null :
                                                    (touched.firstName && errors.firstName ?
                                                        'is-invalid' :
                                                        'is-valid'))}
                                            placeholder={'Enter first name'}
                                            name={'firstName'}
                                        />
                                    </div>

                                    <div className={'form-group p-2'}>
                                        <label>Last name</label>
                                        <Field
                                            type={'text'}
                                            className={'form-control '
                                                + (values.lastName === '' && !touched.lastName ?
                                                    null :
                                                    (touched.lastName && errors.lastName ?
                                                        'is-invalid' :
                                                        'is-valid'))}
                                            placeholder={'Enter last name'}
                                            name={'lastName'}
                                        />
                                    </div>

                                    <div className={'form-group p-2'}>
                                        <label>Email address*</label>
                                        <Field
                                            type={'email'}
                                            className={'form-control '
                                                + (values.email === '' && !touched.email ?
                                                    null :
                                                    (touched.email && errors.email?
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
                                                    (touched.password && (!fiveConditionsForPassword || errors.password) ?
                                                        'is-invalid' :
                                                        'is-valid'))}
                                            placeholder={'Enter password'}
                                            name={'password'}
                                            onKeyUp={(e) => handleChangePassword(e)}
                                            required
                                        />
                                        <div className={'invalid-feedback'}>
                                            <ErrorMessage name="password"/>
                                        </div>
                                    </div>

                                    <div className={'password-rules m-2'}>
                                        <div className={'password-rules-progress'}>
                                            <div className={classnames('password-bar',
                                                twoConditionsForPassword ?
                                                    'password-bar-success-color' :
                                                    'password-bar-default-color')}>
                                            </div>
                                            <div className={classnames('password-bar',
                                                fourConditionsForPassword ?
                                                    'password-bar-success-color' :
                                                    'password-bar-default-color')}>
                                            </div>
                                            <div className={classnames('password-bar',
                                                fiveConditionsForPassword ?
                                                    'password-bar-success-color' :
                                                    'password-bar-default-color')}>
                                            </div>
                                        </div>

                                        <div className={'rules row text-center mt-2'}>

                                            <div className={'col'}>

                                                <div className={
                                                    classnames('row d-flex align-items-center mb-2',
                                                        min8Characters ? 'success-color-span' : 'default-color-span')}>
                                                    <BsCheckCircle size={22}
                                                                   className={classnames('float-right w-auto',
                                                                       min8Characters ?
                                                                           'success-color-span' :
                                                                           'default-color-span')}/>
                                                    <span className={'w-auto'}>Min. 8 characters</span>
                                                </div>

                                                <div className={
                                                    classnames('row d-flex align-items-center mb-2',
                                                        hasNumber ? 'success-color-span' : 'default-color-span')}>
                                                    <BsCheckCircle size={22}
                                                                   className={classnames('float-right w-auto',
                                                                       hasNumber ?
                                                                           'success-color-span' :
                                                                           'default-color-span')}/>
                                                    <span className={'w-auto'}>
                                                        A number
                                                    </span>
                                                </div>

                                            </div>

                                            <div className={'col'}>

                                                <div className={
                                                    classnames('row d-flex align-items-center mb-2',
                                                        hasUppercaseLetter ? 'success-color-span' : 'default-color-span')}>
                                                    <BsCheckCircle size={22}
                                                                   className={classnames('float-right w-auto',
                                                                       hasUppercaseLetter ?
                                                                           'success-color-span' :
                                                                           'default-color-span')}/>
                                                    <span className={'w-auto'}>A uppercase letter</span>
                                                </div>

                                                <div className={
                                                    classnames('row d-flex align-items-center mb-2',
                                                        hasLowercaseLetter ? 'success-color-span' : 'default-color-span')}>
                                                    <BsCheckCircle size={22}
                                                                   className={classnames('float-right w-auto',
                                                                       hasLowercaseLetter ?
                                                                           'success-color-span' :
                                                                           'default-color-span')}/>
                                                    <span className={'w-auto'}>A lowercase letter</span>
                                                </div>

                                                <div className={
                                                    classnames('row d-flex align-items-center mb-2',
                                                        hasSymbol ? 'success-color-span' : 'default-color-span')}>
                                                    <BsCheckCircle size={22}
                                                                   className={classnames('float-right w-auto',
                                                                       hasSymbol ?
                                                                           'success-color-span' :
                                                                           'default-color-span')}/>
                                                    <span className={'w-auto'}>A special symbol</span>
                                                </div>

                                            </div>
                                        </div>

                                    </div>

                                    <div className="form-group p-2">
                                        <label>Repeat password*</label>
                                        <Field
                                            type={'password'}
                                            className={'form-control '
                                                + (values.repeatPassword === '' && !touched.repeatPassword ?
                                                    null :
                                                    (touched.repeatPassword && errors.repeatPassword ?
                                                        'is-invalid' :
                                                        'is-valid'))}
                                            placeholder={'Repeat your password'}
                                            name={'repeatPassword'}
                                            required
                                        />
                                        <div className={'invalid-feedback'}>
                                            <ErrorMessage name="repeatPassword"/>
                                        </div>
                                    </div>

                                    <div className={'p-2 pt-4'}>
                                        <button type={'submit'}
                                                className={'btn btn-primary'}>
                                            Create account
                                        </button>
                                    </div>

                                </Form>
                            )}
                        </Formik>
                    </div>
                </div>

                <div className="text-center">
                    <p>
                        Already have an account?
                        <Link to={'/login'}>Log in</Link>
                    </p>
                </div>

            </div>

            <div className={'image-form w-50'}></div>

        </form>
    )
}

export default SignUp