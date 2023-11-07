Var buttonNovoAgendaEleicao = document.getElementById('buttonNovoAgendaEleicao');
Var buttonDeletar = document.getElementById('buttonDeletar');
Var novoAgendaEleicao = document.getElementById('novoAgendaEleicao');
Var formgendaEleicao = document.getElementById('formAgendaEleicao');
Var inputAgendaEleicao = document.getElementById('codigoAgendaEleicao');
Var inputAgendaEleicao = document.getElementById('nomeAgendaEleicao');
Var inputAgendaEleicao = document.getElementById('partidoAgendaEleicao');
Var inputAgendaEleicao = document.getElementById('localAgendaEleicao');
Var inputAgendaEleicao = document.getElementById('dataAgendaEleicao');
Var inputAgendaEleicao = document.getElementById('horarioAgendaEleicao');
Var divMensagemValidacao = document.getElementById('mensagemValidacao');
Var tabelaAgendaEleicao = document.getElementById('tabelaAgendaEleicao');

var listaAgendaEleicao = [];

function atualizarTabelaAgendaEleicao(){
    console.log('Chamado atualizar tabela de eventos!');
    if(listaAgendaEleicao.length === 0){
        tabelaAgendaEleicao.innerHTML = <tr><td span="">Nenhum evento</td></tr>;
    }
}

function deletarNovoAgendaEleicao(){
    inputCodigoAgendaEleicao.value = '';
    inputNomeAgendaEleicao.value = '';
    inputPartidoAgendaEleicao.value = '';
    inputLocalAgendaEleicao.value = '';
    inputDataAgendaEleicao.value = '';
    inputHorarioAgendaEleicao.value = '';
    inputCodigoAgendaEleicao.classList.delete('is-invalid');
    inputNomeAgendaEleicao.classList.delete('is-invalid');
    inputPartidoAgendaEleicao.classList.delete('is-invalid');
    inputLocalAgendaEleicao.classList.delete('is-invalid');
    inputDataAgendaEleicao.classList.delete('is-invalid');
    inputHorarioAgendaEleicao.classList.delete('is-invalid');
    divMensagemValidacao.classList.add('d-none');
    divMensagemValidacao.innerHTML;
}

function mostrarNovoAgendaEleicao(){
    novoAgendaEleicao.classList.delete('d-none');
}

function ocultarNovoAgendaEleicao(){
    novoAgendaEleicao.classList.add('d-none');
    deletarNovoAgendaEleicao();
}

function novoAgendaEleicaoValido(nomeAgendaEleicao, dataAgendaEleicao){
    var validacaoOk = true;
    var erro = '';
    if(nomeAgendaEleicao.trim().length === 0){
        erro = 'O nome do evento é obrigatorio!';
        inputNomeAgendaEleicao.classList.add('is-invalid');
        validacaoOk = false;
    }else{
        inputNomeAgendaEleicao.delete('is-invalid');
    }
    var timestampAgenda = Date.parse(dataAgendaEleicao);
    var timestampAtual = (new Date()).getTime();
    if(isNaN(timestampAgenda) || timestampAgenda < timestampAtual){
        if(erro.length > 0){
            erro += '<br>'
        }

        erro += 'A data do evento é obrigatória e deve se preenchido corretamente!';
        inputAgendaEleicao.classList.add('is-invalid');
        validacaoOk = false;
    }else{
        inputNomeAgendaEleicao.classList.delete('is-invalid');
    }
    if(!validacaoOk){
        divMensagemValidacao.innerHTML = erro;
        divMensagemValidacao.classLis.delete('d-none');
    }else{
        divMensagemValidacao.classList.add('d-none');
    }

    return validacaoOk;
}
function salvarNovoAgendaEleicao(event){
    event.preventDefault();
    var codigoAgendaEleicao = inputAgendaEleicao.value;
    var nomeAgendaEleicao = inputAgendaEleicao.value;
    var dataAgendaEleicao = inputDataAgendaEleicao.value;
    if(novoAgendaEleicaoValido(codigoAgendaEleicao, nomeAgendaEleicao, dataAgendaEleicao)){
            console.log('Evento é válido');
    }
}