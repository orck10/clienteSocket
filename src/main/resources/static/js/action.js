var host = window.location.origin;

function getRequest(urlPath, dadosHeader) {
    var xmlHttp = new XMLHttpRequest();
    try {
        xmlHttp.open("GET", urlPath, false);
        if (dadosHeader) {
            for (var i = 0; i < dadosHeader.length; i++) {
                xmlHttp.setRequestHeader(dadosHeader[i][0], dadosHeader[i][1]);
            }
        }
        xmlHttp.send(null);
    } catch (error) {
        alert("Falha na requisição tente novamente");
        console.log("Erro :" + error);
        return ""
    }
    return xmlHttp.responseText;
};

function postRequest(urlPath, dadosHeader, body) {
    var xmlHttp = new XMLHttpRequest();
    try {
        xmlHttp.open("POST", urlPath, false);
        if (dadosHeader) {
            for (var i = 0; i < dadosHeader.length; i++) {
                xmlHttp.setRequestHeader(dadosHeader[i][0], dadosHeader[i][1]);
            }
        }
        xmlHttp.send(body);
    } catch (error) {
        alert("Falha na requisição tente novamente");
        console.log("Erro :" + error);
        return "{}"
    }
    if (xmlHttp.status < 300) {
        return xmlHttp.response;
    }
    console.log('{"Erro":"' + xmlHttp.response + '", "Status":"' + xmlHttp.status + '"}');
    return '{"Erro":"' + xmlHttp.response + '", "Status":"' + xmlHttp.status + '"}';
};

function getSeverInfo() {
    var ip = document.getElementById("ip").value;
    var port = document.getElementById("port").value;
    var polynomial = document.getElementById("crc").value;

    return [ip, port, polynomial];
}

function sendTextMessage() {
    var message = document.getElementById("message").value;
    var severInfo = getSeverInfo();

    var requestMessage = {
        "message": message,
        "ip": severInfo[0],
        "port": severInfo[1],
        "polynomial": severInfo[2],
    };

    var header = new Array();
    header[0] = ["Content-Type", "application/json"];

    var resposta = postRequest(host + "/api/message/postmessage/", header, JSON.stringify(requestMessage));
    console.log(resposta);
};

function sendUser() {
    var name = document.getElementById("username").value;
    var age = document.getElementById("age").value;
    var weight = document.getElementById("userweight").value;
    var size = document.getElementById("usersize").value;
    var severInfo = getSeverInfo();

    var requestMessage = {
        "age": age,
        "weight": weight,
        "size": size,
        "name": name,
        "ip": severInfo[0],
        "port": severInfo[1],
        "polynomial": severInfo[2]
    };

    var header = new Array();
    header[0] = ["Content-Type", "application/json"];

    var resposta = postRequest(host + "/api/message/postuser/", header, JSON.stringify(requestMessage));
    console.log(resposta);
};

function requestTime() {
    var timeZone = document.getElementById("time").value;
    var severInfo = getSeverInfo();

    var requestMessage = {
        "message": timeZone,
        "ip": severInfo[0],
        "port": severInfo[1],
        "polynomial": severInfo[2],
    };

    var header = new Array();
    header[0] = ["Content-Type", "application/json"];

    var resposta = postRequest(host + "/api/message/requestTime/", header, JSON.stringify(requestMessage));
    var date = new Date(parseInt(resposta));
    alert("Agora é : " + date)
};