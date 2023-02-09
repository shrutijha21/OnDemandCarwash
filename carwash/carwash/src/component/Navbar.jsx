import React from 'react'


const Navbar = () => {
    return (
        <div>
            <nav class="navbar navbar-expand-lg navbar-light bg-white py-3 shadow-sm">
                <div class="container">
                    <h1 class="navbar-brand fw-bold fs-2" href="#">Car Wash</h1>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav mx-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link" aria-current="page" href="/">Home</a>
                            </li>
                            {/* <li class="nav-item">
                                <a class="nav-link" href="/washpack">Washpacks</a>
                            </li> */}
                            <li class="nav-item">
                                <a class="nav-link" href="/contact">Contact</a>
                            </li>
                            
                        </ul>
                        <div className="buttons">
                            <a href='/login' className='btn btn-outline-dark'>
                                <i className="fa fa-sign-in me-1"></i>
                                Login
                            </a>
                            <a href='/admin-login' className='btn btn-outline-dark ms-2'>
                                <i className="fa fa-sign-in me-1"></i>
                                Admin-login
                            </a>
                            <a href="/register" className='btn btn-outline-dark ms-2'>
                                <i className="fa fa-user-plus me-1"></i>
                            Register
                            </a>
                            {/* <Link to="/register">Register</Link> */}
                            
                            {/* <a href='' className='btn btn-outline-dark ms-2'>
                                <i className="fa fa-shopping-cart me-1"></i>
                                Cart(0)
                            </a> */}
                        </div>
                    </div>
                </div>
            </nav>
        </div>
    )
}

export default Navbar;