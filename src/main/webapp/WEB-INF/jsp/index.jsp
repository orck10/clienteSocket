<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
        <script src="/js/action.js"></script>
    </head>

    <body>
        <div>
            <br/>
            <div>
                <h2>Dados Servidor</h2>
                <label for="ip">Endereï¿½o servidor </label>
                <input type="text" id="ip" name="ip"><br><br>
                <label for="port">Porta servidor </label>
                <input type="number" id="port" name="port"><br><br>
                <label for="crc">Polinï¿½moio CRC em inteiro</label>
                <input type="number" id="crc" name="crc"><br><br>


                <h2>Dados do Usuario</h2>
                <label for="username">Nome Usuario </label>
                <input type="text" id="username" name="username"><br><br>
                <label for="userweight">Peso Usuario </label>
                <input type="number" id="userweight" name="userweight"><br><br>
                <label for="usersize">Tamanho Usuario </label>
                <input type="number" id="usersize" name="usersize"><br><br>
                <label for="usersize">Idade Usuario </label>
                <input type="number" id="age" name="age"><br><br>
                <input id="submituser" class="central" type="submit" value="Submit" onclick="sendUser()"><br><br><br>

                <h2>Mensagem</h2>
                <label for="message">Mensagem  </label>
                <input type="text" id="message" name="message"><br><br>
                <input id="submitMessage" class="central" type="submit" value="Submit" onclick="sendTextMessage()"><br><br><br>

                <label for="time">Selecione a zona</label>
                <select id="time">
                    <option value="America/Los_Angeles">America/Los_Angeles</option>
                    <option value="Europe/Copenhagen">Europe/Copenhagen</option>
                    <option value="America/Sao_Paulo" selected>America/Sao_Paulo</option>
                </select><br><br>
                <input id="submitMessage" class="central" type="submit" value="Submit" onclick="requestTime()"><br><br><br>
            </div>
            <div id="telaJogo"><canvas id="canvas"></canvas></div>
        </div>
    </body>

    </html>