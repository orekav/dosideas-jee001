escuelita.service.pais = (function () {

    var urlService = "/dosideas-jee001-workshop/api/pais/";

    function buscarPorId(idPais) {
        var urlServiceBuscarPorId = urlService + idPais;
        return $.get(urlServiceBuscarPorId);
    }

    return {
        buscarPorId: buscarPorId
    };

})();