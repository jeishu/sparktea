import React from 'react';
import styled from 'styled-components';
import { AccountBox } from '../../components/loginSignup/accountBox';

const LoginSignContainer = styled.div`
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
`;

function LoginSignUp() {
    return (
        <LoginSignContainer className="lsContainer">
            <AccountBox/>
        </LoginSignContainer>
    )
}

export default LoginSignUp
