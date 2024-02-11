# Observability Driven Development

In this session you will learn architectural best practices to help develop a workload health dashboard using X-ray and CloudWatch. Insights from the dashboard will help teams track, inspect and ingest continuous improvement towards operational excellence.

The intent of this session is to educate DevOps teams and managers about Operations Driven Development.

The workshops in this session are dependent on pre-deployed code and can only be completed at AWS run events. To make the most out of these workshops, you will need a basic understanding of Monitoring and Logging concepts, familiarity with the AWS console, and AWS CLI.

## Introduction

If you are someone who writes, runs or sells customer facing products, you likely have to deal with production outages from time to time. When outages occur, having insufficient observability into your system makes it difficult to quickly diagnose and resolve the root cause.

The lack of adequate logging, tracing, and metrics visibility across your entire technology stack means your team spends excessive time trying to piece together what went wrong. This can lead to prolonged downtime, which damages your brand, frustrates customers, and costs your business money.

There is a clear need for full visibility into the health and performance of your applications and infrastructure. In this session, you will explore an effective way to improve observability and troubleshooting. That is to implement precise logging, collecting important metrics, and instrumentation from the start when writing your code and building your applications.

This thinking about Observability requirements early on in the application development lifecycle and coding for better observability is what we would like to term as Observability Driven Developement (ODD)

Observability Driven Development elevates application and infrastructure observability to primary concerns in the development lifecycle. Operational health, security, compliance and business impact are instrumented early in the life cycle to provide comprehensive observability before, during, and after application deployments.

Observability Driven Development aligns with development models like Test Driven Development and Behavior Driven Development:

Application components can be stubbed out at the start of development; they do not need to be in their final forms.
Observing infrastructure and deployment pipelines ensures environment differences and defects introduce during deployment are observable.
Automation is leveraged wherever possible to minimize unintended variation in processes.
Using an Infrastructure as code (IaC) mindset for testing and operations observability improves confidence in workload health and reduces troubleshooting efforts.

## Benefits

Here are some of the benefits we think Observability Driven Development provides

### Operational Excellence
Observability throughout the development lifecycle promotes highly available and resilient applications and systems with early visibility into system performance, including throughput constraints and intermittent impairments.

### Ops and Dev Alignment
Observability Driven Development supports the goals of a DevOps culture, enhancing the site reliability benefits of DevOps with visibility into the system delivering its intended business value.

### Application Performance Guidelines
Observability provide dependable performance metric and KPIs for business and technical stakeholders.

### Faster Debugging
Your teams will troubleshoot and debug faster with granular and contextual inter-component visibility.

### Application Management and Governance Strategy
Application change management and governance metrics and KPIs can also be observed, providing confidence that you are compliant before, during and after deployments.

## Defining Observability

An Organization usually has one or more business functions that help deliver value to its customers. A workload identifies a set of components that together deliver business value. The workload is usually the level of detail that business and technology leaders communicate about. Examples of workloads are marketing websites, e-commerce websites, the back-ends for a mobile app, analytic platforms, etc. Workloads vary in levels of architectural complexity, from static websites to architectures with multiple data stores and many components.

You can also refer to workload components as a System.

The workload components along with infrastructure they are hosted on produce certain signals such as metrics, logs, and traces.

Observability is the capability to continuously generate and discover actionable insights based on signals produced by system under observation. In other words, observability allows users to understand your workload state from its external output and take (corrective) action.

Observability tells you how something is working, or why it is not working.

“Is my system up or down?” “Is it fast or slow as experienced by my end users?” “What KPIs and SLAs should we establish, and how do we know if they’re being met?” When you’re operating at cloud speed and scale, you can’t afford to fly blind: you need to be able to answer a wide range of operational and business questions like these. You need to be able to spot problems as they arise (ideally before they disrupt the customer experience), respond quickly, and resolve them as quickly as possible. To achieve this insight, you need observable systems.