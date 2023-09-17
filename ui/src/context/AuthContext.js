import React, { createContext, useContext, useState, useEffect } from 'react'

const AuthContext = createContext(undefined);

function AuthProvider({ children }) {
  const [user, setUser] = useState(null)

  useEffect(() => {
    const storedUser = JSON.parse(localStorage.getItem('user'))
    setUser(storedUser)
  }, [])

  const getUser = () => {
    return JSON.parse(localStorage.getItem('user'))
  }

  const userIsAuthenticated = () => {
    return localStorage.getItem('token');
  }

  const userLogin = token => {
    localStorage.setItem('token', JSON.stringify(token))
    setUser(token)
  }

  const userLogout = () => {
    localStorage.removeItem('token')
    setUser(null)
  }

  const contextValue = {
    user,
    getUser,
    userIsAuthenticated,
    userLogin,
    userLogout,
  }

  return (
    <AuthContext.Provider value={contextValue}>
      {children}
    </AuthContext.Provider>
  )
}

export default AuthContext

export function useAuth() {
  return useContext(AuthContext)
}

export { AuthProvider }