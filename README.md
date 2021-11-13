# Opencontrol Android SDK

  Libreria de android diseñada para recolectar y enviar la información del dispositivo.
  Current version: v0.0.1
## Beneficios
- La información del dispositivo se envia directamente a nuestros servidores
- La forma de integrar es fácil y rápida
- Todas las dependecias que ocupa la libreria opencontrol-v0.0.1.aar ya estan incluida

## Instalación

- Descargar la ultima versión del SDK (opencontrol-v0.0.1.aar)
- Tener instalado el SDK de Android con versión 29 como minima
- Agregar la libreria android de opencontrol (opencontrol-v0.0.1.aar) al proyecto

## Configuración
Para inicializar la libreria se utilizan los siguientes parámetros:
- **MERCHANT_ID**: Identificador p&uacute;blico del comercio<
- **USERNAME**: Nombre de usuario
- **PUBLIC_API_KEY**: Llave pública del comercio
- **PRODUCTION_MODE**: Bandera que indica si se usa la libreria en producción

## Implementación
```
Opencontrol opencontrol = new Opencontrol("MERCHANT_ID","USERNAME","PUBLIC_API_KEY",PRODUCTION_MODE);
```
## Generación de Session Id
Se debe usar el método **setup** del Objeto Opencontrol inicializado previamente. 
Este método utiliza un listener de tipo **DeviceCollectorListener** para obtener el session id.
Utiliza los siguientes parámetros:
- **CONTEXT**: El contexto de la aplicación</li>
- **Listener**: Objeto del tipo **DeviceCollectorListener** donde se recibe el Session Id generado, la respuesta del servidor y en caso de error la causa de este

```
opencontrol.setup(CONTEXT, new DeviceCollectorListener() {
      @Override
      public void onError(Object o) {
          //DO SOMETHING
      }

      @Override
      public void onResponse(String sessionId,String response) {
          //DO SOMETHING
      }
});
```
## Utilizar modo de Sandbox
Si se quiere utilizar en modo de Sandbox cuado se inicializa el objeto Opencontrol se debe de poner el paremetro PRODUCTION_MODE en false.
