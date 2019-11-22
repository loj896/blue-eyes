// vue.config.js
module.exports = {
    runtimeCompiler: true,
    publicPath: '/', // 设置打包文件相对路径
    devServer: {
        // open: process.platform === 'darwin',
        // host: 'localhost',
        port: 8080,
        // open: true, //配置自动启动浏览器
        proxy: {
            '/sys': {
                target: 'http://localhost:6802/', //对应自己的接口
                changeOrigin: true, //是否允许跨越
                ws: true,
                pathRewrite: {
                    '^/sys': '/sys'
                }
            }
        }
    }
}