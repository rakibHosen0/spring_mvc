<nav class="navbar navbar-expand-lg nav_bar">
    <div class="container-fluid">
        <form class="d-flex pt-3">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item me-3 pt-3">${user.name}</li>
                <li class="nav-item">

                    <a class="nav-link" href="#"><img class="profile" src="${pageContext.request.contextPath}/resources/img/profile.jpg" alt="profile"></a>
                </li>

            </ul>
        </div>
    </div>
</nav>
