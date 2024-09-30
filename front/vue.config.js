//Unite Oeuvre
module.exports = {
    devServer: {
      // Changez l'URL ci-dessous pour correspondre à l'URL de votre API
      proxy: {
        '/unitoeuvre': {
          target: 'http://localhost:8080', // L'URL de votre serveur backend
          changeOrigin: true,
          pathRewrite: { '^/unitoeuvre': '/unitoeuvre' }, // Réécriture du chemin si nécessaire
        },
      },
    },
  };
  