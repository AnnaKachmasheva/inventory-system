import React, {StrictMode} from 'react';
import './index.css';
import App from './App';
import {createRoot} from "react-dom/client";
import {BrowserRouter} from "react-router-dom";

const rootElement = document.getElementById("root");
const root = createRoot(rootElement);

root.render(
    <StrictMode>
        <BrowserRouter>
            <App/>
        </BrowserRouter>
    </StrictMode>
);