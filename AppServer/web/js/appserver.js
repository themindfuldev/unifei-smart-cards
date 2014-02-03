//-- Classes
function Aplicacao(id, nome, descricao) {
   this.id = id;
   this.nome = nome;
   this.descricao = descricao;
}   

//-- Camada 3: eventos da interface
var items;

function indexBuscar()
{
   var consulta = dojo.byId('txtBusca').value;   
   requestBuscar(consulta);
}

function indexListarTudo()
{
   requestBuscar('');
}

function indexRemover()
{
    var indice = dojo.byId('listAplicacoes').selectedIndex;
    if (indice == -1)
    {
        alert("Erro!\nSelecione um item.");    
        return;
    }
    
    var item = items[indice];  
    var id = "";
    for (i=0; i<item.id.length; i++) {
        id += item.id[i];
    }
    requestRemover(id);
}

function indexCarregar()
{
    var indice = dojo.byId('listAplicacoes').selectedIndex;
    if (indice == -1)
    {
        alert("Erro!\nSelecione um item.");    
        return;
    }
  
    var item = items[indice];    
    var id = "";
    for (i=0; i<item.id.length; i++) {
        id += item.id[i];
    }
    
    alert("Certifique-se que a leitora está disponível e o cartão inserido.\n\nO carregamento durará alguns segundos...");
    
    requestCarregar(id);
}

function indexAdicionar()
{
    // Redireciona a janela.
    window.location.href = "adicionar.html";
}

function adicionarOk()
{
    if (dojo.byId("fname").value.length > 0)
      requestAdicionar(dojo.byId('formAdicionar'));
}

function adicionarCancelar()
{
    // Redireciona a janela.
    window.location.href = "index.html";
}

// Função atualizaListagem
function atualizaListagem(items) {
   var applicationsDiv = dojo.byId("divAplicacoes");         
   
   // Se houver aplicações, preenche o select.
   if (items.length > 0) {
     var select = "<select id=\"listAplicacoes\" size=\"10\" style=\"width:400\" class=\"campo\">"; 
     for (var i = 0; i < items.length; i++) {     
        select += "<option>" + items[i].nome + "&nbsp;/&nbsp;" + items[i].descricao + 
                   "</option>";
     }         
     select += "</select>";
     applicationsDiv.innerHTML = select;  
  }
  // Senão, limpa e desabilita.
  else {
     applicationsDiv.innerHTML = "<select id=\"listAplicacoes\" size=\"10\" style=\"width:400\" class=\"campo\"></select>";        
  }

}

//-- Camada 2: utilização de serviços

// Função requestBuscar
function requestBuscar(consulta) 
{
   var args = {
         consulta: consulta
      };
      
   requestPost("BuscarAplicacao", requestBuscarHandler, args);   
}   

// Função requestBuscarHandler
function requestBuscarHandler(type, data, evt) {
   if (type == "load" && data != null) {          
      // Instancia o W3C DOM Parser.
      var parser = new DOMImplementation();

      // Carrega o XML no parser e obtém o DOMDocument.
      var domDoc = parser.loadXML(data);

      // Obtém os nós.
      var listNode = domDoc.getElementsByTagName("list").item(0);
      var itemsLength = listNode.getElementsByTagName("item").length;
      items = new Array();

      // Obtém as aplicações dos cartões.
      for (var j=0; j < itemsLength; j++) {
         var itemNode = listNode.getElementsByTagName("item").item(j);      

         var itemAttributes = itemNode.getAttributes();
         var id = itemAttributes.getNamedItem("id").getNodeValue();
         var nome = itemAttributes.getNamedItem("nome").getNodeValue();
         var descricao = itemNode.getFirstChild().getNodeValue();
         
         items[j] = new Aplicacao(id, nome, descricao);
      }                           

      atualizaListagem(items);
   }
}   

// Função requestRemover
function requestRemover(id) 
{
   var args = {
         id: id
      };
      
   requestPost("RemoverAplicacao", requestRemoverHandler, args);   
}   
// Função requestRemoverHandler
function requestRemoverHandler(type, data, evt) {
   if (type == "load" && data != null) {          
      indexBuscar();
   }
}   

// Função requestCarregar
function requestCarregar(id) 
{
   var args = {
         id: id
      };
      
   requestPost("CarregarAplicacao", requestCarregarHandler, args);   
}   
// Função requestCarregarrHandler
function requestCarregarHandler(type, data, evt) {
   if (type == "load" && data != null) {          
      // Instancia o W3C DOM Parser.
      var parser = new DOMImplementation();

      // Carrega o XML no parser e obtém o DOMDocument.
      var domDoc = parser.loadXML(data);

      // Obtém os nós.
      var applicationNode = domDoc.getElementsByTagName("application").item(0);
      var arquivo = applicationNode.getFirstChild().getNodeValue();

      carregaArquivo(arquivo);
   }
}   

// Função requestImport
function requestAdicionar(form) {
   requestFilePost('AdicionarAplicacao', requestAdicionarHandler, form);  
}   

// Função receiveImport
function requestAdicionarHandler(type, data, evt) {   
   if (type == "load") {
        // Redireciona a janela.
        window.location.href = "index.html";
   }
}

//-- Camada 2.1: applet

function carregaArquivo(arquivo) {
   var resposta = (String) (dojo.byId('applet').carregaArquivo(arquivo));   
   
   dojo.byId('txtResposta').value = resposta;
   dojo.byId('formExibir').submit();
}    

//-- Camada 1: serviços parametrizados

// Função requestPost: Realiza uma requisição usando POST.
function requestPost(urlPost, handlerFunction, params) {
   var args = {
      url: urlPost,
      transport: "XMLHTTPTransport",
      method: "POST",
      handler: handlerFunction,
      error: function(type, error) {
               alert(error.message);
             },
      content: params
   };
   
   dojo.io.bind(args);         
}   

// Função requestPost: Realiza uma requisição, enviando um arquivo, usando POST.
function requestFilePost(urlPost, handlerFunction, form) {
   var args = {
      url: urlPost,
      transport: "IframeTransport",
      handler: handlerFunction,
      error: function(type, error) {
               alert(error.message);
             },
      mimetype: "text/plain", 
      formNode: form
   };
   
   dojo.io.bind(args);         
}   