<!-- Agregar los url de la aplicacion -->
<c:set var="urlInicio">
    <c:url value="${application.contextPath}/" />
</c:set>
<c:set var="urlAgregar">
    <c:url value="${application.contextPath}/agregar" />
</c:set>
<div class="container-fluid mb-2">
        <nav class="navbar navbar-expand-lg navbar-light bg-primary">
            <div class="container-fluid">
                <a class="navbar-brand" href="${urlInicio}">Sistema de empleados</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                        <a class="nav-link" href="${urlInicio}">Inicio</a>
                        <a class="nav-link" href="${urlAgregar}">Agregar</a>
                    </div>
                </div>
            </div>
        </nav>
    </div>