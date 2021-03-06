function ClickName(name, eventName, context, parametersEnrichmentFunctions, parameters) {
    context.arrive('[name="' + name + '"]', options, function () {
        this.addEventListener("click", function(e) {
            parametersEnrichmentFunctions.forEach(function (enrichmentFunction) { enrichmentFunction(context); });
            parameters["event"] = eventName;
            bromium.notifyEvent(parameters);
        });
    });
}
