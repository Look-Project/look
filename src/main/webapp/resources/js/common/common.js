const CONTEXT_PATH = getContextPath();
const BASE_URL = location.origin + CONTEXT_PATH;

function getContextPath(){
    var hostIndex = location.href.indexOf( location.host ) + location.host.length;
    var contextPath = location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
    return contextPath;
}