package com.hribol.bromium.replay.filters;

import io.netty.handler.codec.http.HttpRequest;

import java.net.URISyntaxException;
import java.util.Set;

/**
 * Created by hvrigazov on 20.05.17.
 */
public class ReplayFiltersFactory {

    public ReplayRequestFilter createReplayRequestFilter(String baseURI,
                                                         Set<HttpRequest> httpRequestQueue) throws URISyntaxException {
        return new ReplayRequestFilter(baseURI, httpRequestQueue);
    }

    public ReplayResponseFilter createReplayResponseFilter(String injectionCode, String baseURI, Set<HttpRequest> httpRequestQueue) throws URISyntaxException {
        return new ReplayResponseFilter(injectionCode, baseURI, httpRequestQueue);
    }
}