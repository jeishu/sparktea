import styled from "styled-components";

export const BoxContainer = styled.div`
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 10px;
`;

export const FormContainer = styled.form`
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  //box-shadow: 0px 0px 2.5px rgba(15, 15, 15, 0.19);
  //Media Queries
  //ipad and above to Desktop
  @media only screen and (min-width: 768px) {
    box-shadow: 0px 0px 2.5px rgba(15, 15, 15, 0.19);
  }
`;

export const MutedLink = styled.a`
  font-size: 11px;
  color: rgba(200, 200, 200, 0.8);
  font-weight: 500;
  text-decoration: none;
`;

export const BoldLink = styled.a`
  font-size: 11px;
  color: #00d5c5;
  font-weight: 500;
  text-decoration: none;
  margin: 0 4px;
`;

export const Input = styled.input`
  width: 100%;
  height: 30px;
  outline: none;
  //border: 1px solid rgba(200, 200, 200, 0.3);
  border: none;
  padding: 1px 9px;
  /* margin: 5px 0; */
  /* border-radius: 5px; */
  /* background-color: rgba(130, 130, 130, 0.104); */
  // background-color: transparent;
  border-bottom: 1px solid rgba(238, 238, 238, 0.104);
  transition: all 200ms ease-in-out;
  font-size: 12px;
  &::placeholder {
    color: rgba(200, 200, 200, 1);
  }
  /* &:not(:last-of-type) {
    border-bottom: 1.5px solid rgba(200, 200, 200, 0.4);
  } */
  &:focus {
    outline: none;
    border-bottom: 2px solid rgb(69, 211, 230);
  }
  /* background: linear-gradient(to right, rgb(240, 240, 240) 50%, rgb(124, 124, 124) 50%) left;
  background-size: 200%;
  &:hover, &:active {
      background-position: right;
      color: white;
  } */
`;

export const SubmitButton = styled.button`
  width: 100%;
  padding: 4px;
  color: #fff;
  font-size: 14px;
  border: none;
  border-radius: 100px;
  cursor: pointer;
  transition: all, 240ms ease-in-out;
  background: rgb(0,61,255);
    background: linear-gradient(90deg,
         #6382e9 0%, 
         #00aa9c 49%, 
         #327e59 100%);
  );
  &:hover {
    filter: brightness(1.03);
  }
`;