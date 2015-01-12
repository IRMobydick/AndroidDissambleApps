package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;

public final class aJ
  implements ap
{
  private static Map a = new HashMap();
  private static Map b = new HashMap();
  private static Map c = new HashMap();

  public aJ()
  {
    a.put(bG.a, "A autenticar");
    a.put(bG.b, "Voltar");
    a.put(bG.c, "Cancelar");
    a.put(bG.d, "A verificar o dispositivo…");
    a.put(bG.e, "Apagar informações do cartão");
    a.put(bG.f, "Confirmar");
    a.put(bG.g, "Tem a certeza de que pretende apagar os dados do seu cartão?");
    a.put(bG.h, "Debitar no cartão");
    a.put(bG.i, "Tem a certeza de que pretende terminar a sessão no PayPal?");
    a.put(bG.j, "Enviar pagamento");
    a.put(bG.k, "Concordo");
    a.put(bG.l, "%s pede-lhe para:");
    a.put(bG.m, "<a href='%1$s'>Autorizar débitos</a> para compras futuras feitas em %2$s pagas com PayPal. Está a dar ao PayPal instruções para pagar todos os montantes solicitados por %3$s.");
    a.put(bG.n, "Partilhar informações básicas sobre a sua conta.");
    a.put(bG.o, "Concordar com a <a href='%2$s'>Política de Privacidade</a> e o <a href='%3$s'>Contrato do Utilizador</a> de %1$s.");
    a.put(bG.p, "Autorizar");
    a.put(bG.q, "E-mail");
    a.put(bG.r, "Dados fictícios");
    a.put(bG.s, "Sandbox");
    a.put(bG.t, "Validade");
    a.put(bG.u, "Esqueceu-se da palavra-passe?");
    a.put(bG.v, "De");
    a.put(bG.w, "De que forma gostaria de financiar os pagamentos futuros a %1$s?");
    a.put(bG.x, "<h1><strong>Acordo de Pagamento Futuro</strong></h1><p>A sua fonte de financiamento predefinida será usada para pagamentos futuros com PayPal efetuados com este vendedor.</p><p>Para cancelar este contrato, inicie a sessão na sua conta PayPal, entre em <strong>Perfil</strong> &gt; <strong>As minhas definições</strong> &gt; <strong>Iniciar a sessão com PayPal</strong> e remova este vendedor da lista.</p><p>Aplica-se a secção de Pagamento Periódico do <a href='%s'>Contrato do Utilizador do PayPal</a>.</p><p>Para garantir que os pagamentos são efetuados corretamente com a sua conta PayPal, esta aplicação pode simular uma pequena transação de teste, mas não será transferido qualquer dinheiro.</p>");
    a.put(bG.y, "Erro interno");
    a.put(bG.z, "<p>Ao clicar no botão em baixo, confirmo que concordo com os termos do <a href='%1$s'>Contrato do Utilizador do PayPal</a> e declaro que estou em conformidade com as leis e regulamentos japoneses, inclusive as sanções contra pagamentos à Coreia do Norte e ao Irão definidas na <a href='%2$s'>Lei do Câmbio Internacional e Comércio Externo (Foreign Exchange and Foreign Trade Act)</a>, para concluir a transação.</p>");
    a.put(bG.A, "Iniciar sessão");
    a.put(bG.B, "Iniciar sessão com PayPal");
    a.put(bG.C, "Terminar sessão");
    a.put(bG.D, "Terminar sessão");
    a.put(bG.E, "OK");
    a.put(bG.F, "Palavra-passe");
    a.put(bG.G, "Pagar com");
    a.put(bG.H, "Pagar com cartão");
    a.put(bG.I, "Telefone");
    a.put(bG.J, "PIN");
    a.put(bG.K, "O PayPal protege a sua <a href='%s'>privacidade</a> e os seus dados financeiros.");
    a.put(bG.L, "A processar");
    a.put(bG.M, "Memorizar cartão");
    a.put(bG.N, "Ocorreu um erro ao comunicar com os servidores do PayPal. Por favor, tente novamente.");
    a.put(bG.O, "Por favor, inicie novamente a sessão no PayPal.");
    a.put(bG.P, "A sessão expirou");
    a.put(bG.Q, "Manter a sessão iniciada");
    a.put(bG.R, "Erro de sistema (%s). Por favor, tente novamente mais tarde.");
    a.put(bG.S, "Tente novamente");
    a.put(bG.T, "Não são permitidos pagamentos com este dispositivo.");
    a.put(bG.U, "Dispositivo não autorizado");
    a.put(bG.V, "Não são permitidos pagamentos a este vendedor (ID de cliente inválida).");
    a.put(bG.W, "Vendedor inválido");
    a.put(bG.X, "O seu pedido");
    a.put(bG.Y, "Apagar cartão?");
    a.put(bG.Z, "Erro na autorização");
    a.put(bG.aa, "Falha na ligação");
    a.put(bG.ab, "Falha de início de sessão");
    a.put(bG.ac, "Iniciar sessão com palavra-passe");
    a.put(bG.ad, "Iniciar sessão com PIN");
    a.put(bG.ae, "Aguarde…");
    a.put(bG.af, "O pagamento falhou");
    a.put(bG.ag, "Ler");
    a.put(bG.ah, "Via");
    b.put("CONSENT_AGREEMENT_FUTURE_PAYMENTS|US", "Pré-aprovar pagamentos futuros feitos com a sua <a href='%1$s'>conta PayPal</a>.");
    b.put("CONSENT_AGREEMENT_FUTURE_PAYMENTS|AU", "<p><a href='%1$s'>Autorizar débitos</a> para compras futuras feitas em %2$s pagas com PayPal. Está a dar ao PayPal instruções para pagar todos os montantes solicitados por %3$s.</p><p>Queira consultar o <a href='https://www.paypal.com/webapps/mpp/ua/recurringpymts-full'>Contrato de Pagamentos Recorrentes e Faturação do PayPal</a> para mais informações.</p>");
    b.put("CONSENT_AGREEMENT_FUTURE_PAYMENTS|CN", "<p><a href='%1$s'>Autorizar débitos</a> para compras futuras feitas em %2$s pagas com PayPal. Está a dar ao PayPal instruções para pagar todos os montantes solicitados por %3$s.</p><p>Queira consultar o <a href='https://cms.paypal.com/c2/cgi-bin/?cmd=_render-content&content_ID=ua/UserAgreement_full'>Contrato de Pagamentos Recorrentes e Faturação do PayPal</a> para mais informações.</p>");
    b.put("FUTURE_PAYMENT_LEGAL_DETAILS|US", "<h1><strong>Acordo de Pagamento Futuro</strong></h1><p>O PayPal irá usar em primeiro lugar o seu saldo PayPal para fazer o pagamento de compras. Se o saldo não for suficiente para cobrir o valor total, o PayPal irá usar de seguida a sua conta bancária, o cartão de débito, o cartão de crédito e/ou o eCheck, por esta ordem.</p><p>Para cancelar este contrato, visite www.paypal.com, entre em <strong>Perfil</strong> &gt; <strong>As minhas definições</strong> &gt; <strong>Iniciar a sessão com PayPal</strong> e remova este vendedor da lista.</p><p>Pode ser necessária a autorização de um pagamento de baixo valor para garantir que a sua conta PayPal possa ser debitada no futuro. A autorização será anulada e não será efetuado qualquer débito.</p>");
    b.put("FUTURE_PAYMENT_LEGAL_DETAILS|AU", "<h1><strong>Acordo de Pagamento Futuro</strong></h1><p>Para garantir que a sua conta PayPal possa ser debitada no futuro, esta aplicação pode simular uma pequena transação de teste, mas não será transferido qualquer dinheiro.</p><p>O seu meio de pagamento predefinido (saldo PayPal, conta bancária associada, cartão de débito ou de crédito, por esta ordem) será usado para o pagamento de compras com PayPal. Tenha em atenção que, se o meio de pagamento predefinido não tiver fundos suficientes para cobrir a compra, o seu banco ou fornecedor do cartão poderá cobrar uma tarifa.</p><p>Para cancelar este contrato, inicie a sessão na sua conta PayPal e entre em <strong>Perfil</strong>, depois clique em <strong>As minhas definições</strong> e em <strong>Alterar</strong>, ao lado de “Iniciar a sessão com PayPal”.</p>");
    b.put("FUTURE_PAYMENT_LEGAL_DETAILS|CN", "<h1><strong>Acordo de Pagamento Futuro</strong></h1><p>Para garantir que a sua conta PayPal possa ser debitada no futuro, esta aplicação pode simular uma pequena transação de teste, mas não será transferido qualquer pagamento.</p><p>O seu meio de pagamento predefinido será usado para o pagamento de compras com PayPal.</p><p>Para cancelar este contrato, inicie a sessão na sua conta PayPal, entre em <strong>Perfil</strong> &gt; <strong>As minhas definições</strong> &gt; <strong>Iniciar sessão com PayPal</strong> e remova este vendedor da lista.</p>");
    b.put("FUTURE_PAYMENT_LEGAL_DETAILS|HK", "<h1><strong>Autorização de Pagamento Futuro</strong></h1><p>Para garantir que a sua conta PayPal possa ser debitada no futuro, esta aplicação pode simular uma pequena transação de teste, mas não será transferido qualquer pagamento.</p><p>O seu meio de pagamento predefinido será usado para o pagamento de compras com PayPal.</p><p>Para cancelar esta autorização, inicie a sessão na sua conta PayPal, entre em <strong>Perfil</strong> &gt; <strong>As minhas definições</strong> &gt; <strong>Iniciar a sessão com PayPal</strong> e remova este vendedor da lista.</p><p>Para mais informações, consulte por favor a secção “Pagamentos pré-aprovados” do <a href='%s'>Contrato do Utilizador do PayPal</a>.</p>");
    b.put("FUTURE_PAYMENT_LEGAL_DETAILS|SG", "<h1><strong>Autorização de Pagamento Futuro</strong></h1><p>Para garantir que a sua conta PayPal possa ser debitada no futuro, esta aplicação pode simular uma pequena transação de teste, mas não será transferido qualquer pagamento.</p><p>O seu meio de pagamento predefinido será usado para o pagamento de compras com PayPal.</p><p>Para cancelar esta autorização, inicie a sessão na sua conta PayPal, entre em <strong>Perfil</strong> &gt; <strong>As minhas definições</strong> &gt; <strong>Iniciar a sessão com PayPal</strong> e remova este vendedor da lista.</p><p>Para mais informações, consulte por favor a secção “Pagamentos pré-aprovados” do <a href='%s'>Contrato do Utilizador do PayPal</a>.</p>");
    b.put("FUTURE_PAYMENT_LEGAL_DETAILS|JP", "<h1><strong>Autorização de Pagamento Futuro</strong></h1><p>Para garantir que a sua conta PayPal possa ser debitada no futuro, esta aplicação pode simular uma pequena transação de teste, mas não será transferido qualquer pagamento.</p><p>O seu meio de pagamento predefinido será usado para o pagamento de compras com PayPal.</p><p>Para cancelar esta autorização, inicie a sessão na sua conta PayPal, entre em <strong>Perfil</strong> &gt; <strong>As minhas definições</strong> &gt; <strong>Iniciar a sessão com PayPal</strong> e remova este vendedor da lista.</p><p>Para mais informações, consulte por favor a secção “Pagamentos pré-aprovados” do <a href='%s'>Contrato do Utilizador do PayPal</a>.</p>");
    b.put("FUTURE_PAYMENT_LEGAL_DETAILS|BR", "<h1><strong>Acordo de Pagamento Futuro</strong></h1><p>Para garantir que a sua conta PayPal possa ser debitada no futuro, esta aplicação poderá simular uma pequena transação de teste, mas não será transferido qualquer valor.</p><p>O seu saldo PayPal ou o seu cartão de crédito ou de débito predefinido será usado para o pagamento de compras com PayPal.</p><p>Para cancelar este contrato, inicie a sessão na sua conta PayPal, entre em <strong>Perfil</strong> &gt; <strong>As minhas definições</strong> &gt; <strong>Iniciar a sessão com PayPal</strong> e remova este vendedor da lista.</p>");
    b.put("FUTURE_PAYMENT_LEGAL_DETAILS|MX", "<h1><strong>Acordo de Pagamento Futuro</strong></h1><p>Para garantir que a sua conta PayPal possa ser debitada no futuro, esta aplicação poderá simular uma pequena transação de teste, mas não será transferido qualquer valor.</p><p>O seu saldo PayPal ou o seu cartão de crédito ou de débito predefinido será usado para o pagamento de compras com PayPal.</p><p>Para cancelar este contrato, inicie a sessão na sua conta PayPal, entre em <strong>Perfil</strong> &gt; <strong>As minhas definições</strong> &gt; <strong>Iniciar a sessão com PayPal</strong> e remova este vendedor da lista.</p>");
    c.put("INTERNAL_SERVICE_ERROR", "Erro de sistema. Por favor, tente novamente mais tarde.");
    c.put("EXPIRED_CREDIT_CARD", "O cartão expirou");
    c.put("EXPIRED_CREDIT_CARD_TOKEN", "Os dados deste cartão já não se encontram arquivados.\nPor favor, envie-os novamente.");
    c.put("INVALID_ACCOUNT_NUMBER", "Esse número de conta não existe.");
    c.put("INVALID_RESOURCE_ID", "Erro de sistema. Por favor, tente novamente mais tarde.");
    c.put("DUPLICATE_REQUEST_ID", "Erro de sistema. Por favor, tente novamente mais tarde.");
    c.put("TRANSACTION_LIMIT_EXCEEDED", "O valor excede o limite permitido.");
    c.put("REFUND_EXCEEDED_TRANSACTION_AMOUNT", "O reembolso solicitado excede o valor da transação original.");
    c.put("REFUND_TIME_LIMIT_EXCEEDED", "Esta transação é demasiado antiga para ser reembolsada.");
    c.put("FULL_REFUND_NOT_ALLOWED_AFTER_PARTIAL_REFUND", "Esta transação já foi parcialmente reembolsada.");
    c.put("TRANSACTION_ALREADY_REFUNDED", "Esta transação já foi reembolsada.");
    c.put("CAPTURE_AMOUNT_LIMIT_EXCEEDED", "O valor excede o limite permitido.");
    c.put("AUTHORIZATION_ALREADY_COMPLETED", "Esta autorização já foi concluída.");
    c.put("CANNOT_REAUTH_CHILD_AUTHORIZATION", "Só é possível reautorizar a autorização original e não uma reautorização.");
    c.put("CANNOT_REAUTH_INSIDE_HONOR_PERIOD", "A reautorização não é permitida dentro do período de honra.");
    c.put("TOO_MANY_REAUTHORIZATIONS", "Não são permitidas mais reautorizações para esta autorização.");
    c.put("PERMISSION_DENIED", "A operação solicitada não é permitida.");
    c.put("AUTHORIZATION_VOIDED", "A autorização foi anulada.");
    c.put("AUTHORIZATION_ID_DOES_NOT_EXIST", "A ID de autorização solicitada não existe.");
    c.put("VALIDATION_ERROR", "A informação sobre o pagamento é inválida. Por favor, corrija e envie novamente.");
    c.put("CREDIT_CARD_REFUSED", "Cartão recusado.");
    c.put("CREDIT_CARD_CVV_CHECK_FAILED", "As informações do cartão são inválidas. Por favor, corrija e envie novamente.");
    c.put("PAYEE_ACCOUNT_RESTRICTED", "Este fornecedor não pode receber pagamentos de momento.");
    c.put("PAYMENT_NOT_APPROVED_FOR_EXECUTION", "O pagante não aprovou o pagamento.");
    c.put("INVALID_PAYER_ID", "Erro de sistema (ID de pagante inválida). Por favor, tente novamente mais tarde.");
    c.put("PAYEE_ACCOUNT_LOCKED_OR_CLOSED", "Este fornecedor não pode receber pagamentos de momento.");
    c.put("PAYMENT_APPROVAL_EXPIRED", "A aprovação do pagamento expirou.");
    c.put("PAYMENT_EXPIRED", "O pagamento expirou.");
    c.put("DATA_RETRIEVAL", "Erro de sistema. Por favor, tente novamente mais tarde.");
    c.put("PAYEE_ACCOUNT_NO_CONFIRMED_EMAIL", "A conta do beneficiário não tem um e-mail confirmado.");
    c.put("PAYMENT_STATE_INVALID", "Este pedido é inválido devido ao estado atual do pagamento.");
    c.put("TRANSACTION_REFUSED", "A transação foi recusada.");
    c.put("AMOUNT_MISMATCH", "O total de artigos no carrinho de compras não coincide com o valor da venda.");
    c.put("CURRENCY_NOT_ALLOWED", "Esta moeda não é suportada atualmente pelo PayPal.");
    c.put("CURRENCY_MISMATCH", "A moeda de captura deve ser idêntica à moeda de autorização.");
    c.put("AUTHORIZATION_EXPIRED", "A autorização expirou.");
    c.put("INVALID_ARGUMENT", "Transação recusada devido a um argumento inválido");
    c.put("PAYER_ID_MISSING_FOR_CARD_TOKEN", "Não é possível aceder às informações guardadas do cartão.");
    c.put("CARD_TOKEN_PAYER_MISMATCH", "Não é possível aceder às informações guardadas do cartão.");
    c.put("AUTHORIZATION_CANNOT_BE_VOIDED", "O estado da autorização não permite a anulação.");
    c.put("REQUIRED_SCOPE_MISSING", "Erro de sistema. Tente novamente mais tarde.");
    c.put("UNAUTHORIZED_PAYMENT", "O vendedor não aceita pagamentos deste tipo.");
    c.put("DCC_UNSUPPORTED_CURRENCY_CC_TYPE", "Moeda sem suporte para o tipo de cartão.");
    c.put("DCC_CC_TYPE_NOT_SUPPORTED", "Tipo de cartão não suportado.");
    c.put("INSUFFICIENT_FUNDS", "O comprador não consegue pagar - fundos insuficientes.");
    c.put("TRANSACTION_REFUSED_PAYEE_PREFERENCE", "A preferência no perfil do vendedor está configurada para recusar automaticamente determinadas transações.");
    c.put("INVALID_FACILITATOR_CONFIGURATION", "Esta transação não pode ser processada devido a uma configuração de facilitador inválida.");
    c.put("AUTH_RC_RISK_FAILURE", "Recusado devido a risco.");
    c.put("AUTH_RC_OFAC_BLOCKED_IP", "Cliente não autorizado.");
    c.put("AUTH_RC_IP_COMPLIANCE_FAILURE", "Cliente não autorizado.");
    c.put("invalid_user", "Nome de utilizador ou palavra-passe incorrecto. Por favor, tente novamente.");
    c.put("invalid_request", "Ocorreu um erro.");
    c.put("unauthorized_client", "Pedido não autorizado.");
    c.put("access_denied", "Pedido não autorizado.");
    c.put("unsupported_response_type", "Ocorreu um erro.");
    c.put("invalid_scope", "Pedido não autorizado.");
    c.put("server_error", "Erro de sistema. Por favor, tente novamente mais tarde.");
    c.put("temporarily_unavailable", "Erro de sistema. Por favor, tente novamente mais tarde.");
  }

  public final String a()
  {
    return "pt";
  }

  public final String a(String paramString)
  {
    return (String)c.get(paramString);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.aJ
 * JD-Core Version:    0.6.2
 */