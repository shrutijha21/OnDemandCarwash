import React from 'react'

const Home = () => {
    return (
        <div className='hero'>
            <div class="card bg-dark text-white border-0">
                <img src="/assets/bg.jpg" class="card-img" alt="Baground" height="600px"/>
                    <div class="card-img-overlay d-flex flex-column ">
                        <div className='container'>
                            <h5 class="card-title display-3 fw-bolder mb-0">Get your car wash today</h5>
                            <p class="card-text lead fs-2"> Check out our Exciting prices</p>
                        </div>
                    </div>
            </div>

        </div>
    );
}

export default Home;