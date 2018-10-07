module.exports = {
  outputDir: "dist/META-INF/resources",
  devServer: {
    proxy: "http://localhost:8080",
    port: 8081
  }
};
