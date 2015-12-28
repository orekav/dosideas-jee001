escuelita.ui.pais = (function () {

    var $bodyTablaPais = $("#bodyTablaPais");
    var $spanIdPaisEncontrado = $("#idPaisEncontrado");
    var $divMensajeNoEncontrado = $("#mensajeNoEncontrado");

    function inicializar() {
        buscar(1);
        bindearEventosABotones();
    }

    function buscar(idPais) {
        escuelita.service.pais.buscarPorId(idPais)
                .done(mostrar)
                .fail(mostrarMensajeNoEncontrado);
    }

    function mostrar(pais) {
        $bodyTablaPais.html("<tr><td>" + pais.id + "</td><td>" + pais.nombre + "</td></tr>");
        $spanIdPaisEncontrado.text(pais.id);
    }

    function bindearEventosABotones() {
        $("#botonBuscarPaisPorId").on("click", function () {
            $("#mensajeNoEncontrado").addClass("hide");
            var idPaisABuscar = $("#idPaisABuscar").val();
            buscar(idPaisABuscar);
        });
    }

    function mostrarMensajeNoEncontrado() {
        $bodyTablaPais.text("");
        $spanIdPaisEncontrado.text("");
        $divMensajeNoEncontrado.removeClass("hide");
    }

    return {
        inicializar: inicializar,
        buscar: buscar
    };

})();

$(document).ready(function () {
    escuelita.ui.pais.inicializar();
});