var LEQCAR = LEQCAR || {};

LEQCAR.greeting = function() {

    var stompClient = null;

    function _init() {
        _bindEvent()
        disconnect()
        console.log("Disconnected");

    }

    function _bindEvent() {
        $('#connect').on("click", function() {
            connect();
        });

        $('#sendName').on("click", function() {
            sendName();
        });

        $('#disconnect').on("click", function() {
            disconnect();
        });
    }

    function connect() {
        var socket = new SockJS('/hello');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function(frame) {
            setConnected(true);
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/greetings', function(greeting){
                showGreeting(JSON.parse(greeting.body).content);
            });
        });
    }

    function setConnected(connected) {
        $('#connect').prop("disabled", connected);
        $('#disconnect').prop("disabled", !connected);
        if (connected) {
            $('#conversationDiv').show()
        } else {
            $('#conversationDiv').hide()
        }
        $('#response').innerHTML = '';
    }

    function sendName() {
        var name = $('#name').val();
        console.log("Name : "+name);
        stompClient.send("/app/hello", {}, JSON.stringify({ 'name': name }));
    }

    function showGreeting(message) {
        var response = $('#response');
        response.css('word-wrap', 'break-word');
        response.append(document.createTextNode(message)).append("</br>");
    }

    function disconnect() {
        if (stompClient != null) {
            stompClient.disconnect();
        }
        setConnected(false);
        console.log("Disconnected");
    }

    return {
        init : _init
    };

}();
